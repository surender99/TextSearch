package com.example.TextSearch.Repository;

import com.example.TextSearch.Entity.DocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<DocumentEntity, Long> {
    //@Query("SELECT d FROM documentEntity d WHERE d.title LIKE %:searchTerm% OR d.author LIKE %:searchTerm% OR LOCATE(:searchTerm, d.content) > 0")
    @Query("SELECT d FROM DocumentEntity d WHERE lower(d.title) LIKE %:searchTerm% OR lower(d.author) LIKE %:searchTerm% OR lower(d.content) LIKE %:searchTerm%")
    List<DocumentEntity> searchDocuments(@Param("searchTerm") String searchTerm);
}
