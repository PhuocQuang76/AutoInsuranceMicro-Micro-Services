package com.synergisticit.dto;

public class FileUploadRequest {
    private String username;
    private byte[] fileContent;

    public FileUploadRequest(String username, byte[] fileContent) {
        this.username = username;
        this.fileContent = fileContent;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }
}