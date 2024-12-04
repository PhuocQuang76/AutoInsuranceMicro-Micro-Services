package com.synergisticit.repository;

import com.synergisticit.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
    public List<Document> findByUsername(String username);
}
