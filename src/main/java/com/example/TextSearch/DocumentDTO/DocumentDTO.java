package com.example.TextSearch.DocumentDTO;

import com.example.TextSearch.Entity.DocumentEntity;
import com.example.TextSearch.Model.Document;

public class DocumentDTO {
    public static Document toDocument(DocumentEntity entity) {
        Document document = new Document();
        document.setTitle(entity.getTitle());
        document.setAuthor(entity.getAuthor());
        document.setContent(entity.getContent());
        return document;
    }
}
