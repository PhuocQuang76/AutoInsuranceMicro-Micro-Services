package com.synergisticit.domain;

import jakarta.persistence.*;



@Entity
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;

    private String fileName;

    private DocumentStatus status;

    private String comment;

//    @Lob
//    private byte[] data;

    public Document() {
    }

    public Document(Long id, String username, String fileName, DocumentStatus status, String comment) {
        this.id = id;
        this.username = username;
        this.fileName = fileName;
        this.status = status;
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}