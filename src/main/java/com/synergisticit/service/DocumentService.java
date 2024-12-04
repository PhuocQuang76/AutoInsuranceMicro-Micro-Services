package com.synergisticit.service;

import com.synergisticit.domain.Document;
import com.synergisticit.domain.Document_BK;
import com.synergisticit.dto.DocumentUpdateDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.util.List;


@Service
public interface DocumentService {
    Document saveDocument(Document document) throws IOException;

    Document updateDocument(Document document) throws IOException;

    void deleteDocument(Long documentId);

    List<Document> getAllDocument();

    List<Document> getAllDocumentByUsername(@PathVariable String username);

    Document getDocumentById(@PathVariable Long documentId);

    Document updateDocument(DocumentUpdateDTO documentUpdateDTO);
}
