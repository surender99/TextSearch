package com.example.TextSearch.Controller;
import com.example.TextSearch.Model.Document;
import com.example.TextSearch.Service.TextSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {
    @Autowired
    TextSearchService textSearchService;

    @GetMapping("/search")
    public List<Document> search(@RequestParam("find") String searchString) {
        return textSearchService.search(searchString);
    }

    @PostMapping("/")
    public Document createDocument(@RequestBody Document document) {
        return textSearchService.saveDocument(document);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document document) {
        return ResponseEntity.ok(textSearchService.updateDocument(id, document));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Delete Book entity object by ID
        textSearchService.deleteDocument(id);
        // Return 204 No Content in the response
        return ResponseEntity.noContent().build();
    }
}
