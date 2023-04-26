package com.example.TextSearch.Service;

import com.example.TextSearch.DocumentDTO.DocumentDTO;
import com.example.TextSearch.DocumentDTO.DocumentEntityDTO;
import com.example.TextSearch.Entity.DocumentEntity;
import com.example.TextSearch.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TextSearch.Model.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TextSearchService {
    private final DocumentRepository documentRepository;
    @Autowired
    public TextSearchService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document saveDocument(Document document) {
        DocumentEntity documentEntity = DocumentEntityDTO.toDocumentEntityDTO(document);
        DocumentEntity savedDocumentEntity =  documentRepository.save(documentEntity);
        return DocumentDTO.toDocument(savedDocumentEntity);
    }

    public Document  updateDocument(Long id, Document document) {
        DocumentEntity existingDocument = documentRepository.findById(id).orElse(null);
        if (existingDocument != null) {
            DocumentEntity newDocument = DocumentEntityDTO.toDocumentEntityDTO(document);
            existingDocument.setTitle(newDocument.getTitle());
            existingDocument.setAuthor(newDocument.getAuthor());
            existingDocument.setContent(newDocument.getContent());
            DocumentEntity documentEntity = documentRepository.save(existingDocument);
            return DocumentDTO.toDocument(documentEntity);
        }
        return null;
    }

    public void deleteDocument(Long id) {
        documentRepository.deleteById(id);
    }

    public List<Document> search(String searchString) {
        List<Document> documents = new ArrayList<>();

        for (DocumentEntity documentEntity: documentRepository.searchDocuments(searchString)) {
            Document document = DocumentDTO.toDocument(documentEntity);
            documents.add(document);
        }
        return documents;
    }
}
