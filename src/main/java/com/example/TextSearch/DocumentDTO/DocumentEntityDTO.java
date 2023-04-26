package com.example.TextSearch.DocumentDTO;

import com.example.TextSearch.Entity.DocumentEntity;
import com.example.TextSearch.Model.Document;

import java.nio.charset.StandardCharsets;

public class DocumentEntityDTO {
    public static DocumentEntity toDocumentEntityDTO(Document document) {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setTitle(document.getTitle());
        documentEntity.setAuthor(document.getAuthor());
        documentEntity.setContent(document.getContent());
        return documentEntity;
    }
}
