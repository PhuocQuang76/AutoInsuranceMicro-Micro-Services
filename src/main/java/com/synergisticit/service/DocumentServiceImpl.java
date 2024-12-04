package com.synergisticit.service;

import com.synergisticit.domain.Document;

import com.synergisticit.domain.DocumentStatus;
import com.synergisticit.dto.DocumentUpdateDTO;
import com.synergisticit.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService{
    @Autowired
    private DocumentRepository documentRepository;


    @Override
    public Document saveDocument(Document document) throws IOException {
        //document.setStatus(DocumentStatus.PENDING);
        Document saveDocument = documentRepository.save(document);
        return document;
    }

    @Override
    public Document updateDocument(Document document) throws IOException {

        Document saveDocument = documentRepository.save(document);

        //Save file into DISK

        return document;
    }

    @Override
    public void deleteDocument(Long documentId) {
        documentRepository.deleteById(documentId);
    }

    @Override
    public List<Document> getAllDocument() {
        return documentRepository.findAll();
    }

    @Override
    public List<Document> getAllDocumentByUsername(String username) {
        return documentRepository.findByUsername(username);
    }

    @Override
    public Document getDocumentById(Long documentId) {
        Optional<Document> document= documentRepository.findById(documentId);
        if(document.isPresent()){
            return document.get();
        }
        return null;
    }

    @Override
    public Document updateDocument(DocumentUpdateDTO documentUpdateDTO) {
        Long documentId = documentUpdateDTO.getDocumentId();
        DocumentStatus status = documentUpdateDTO.getStatus();

        Document document = getDocumentById(documentId);
        document.setStatus(status);


        try {
            return saveDocument(document);
        } catch (IOException e) {
            System.out.println("DocumentId: " + documentId + " is not exist");
            throw new RuntimeException(e);
        }
    }

}
