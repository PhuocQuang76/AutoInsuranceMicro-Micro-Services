package com.synergisticit.dto;

import com.synergisticit.domain.DocumentStatus;

public class DocumentUpdateDTO {
    Long documentId;
    DocumentStatus status;

    String username;

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
