package com.synergisticit.controller;
import com.synergisticit.domain.Document;
import com.synergisticit.domain.DocumentStatus;
import com.synergisticit.dto.DocumentDTO;
import com.synergisticit.dto.DocumentUpdateDTO;
import com.synergisticit.service.DocumentService;
import com.synergisticit.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
public class DocumentController {
    @Value("${FILE_PATH}")
    private String path;

    @Autowired
    private FileService fileService;
    @Autowired
    DocumentService documentService;

//    @PostMapping("/document/save")
//    public Document saveDocument(@RequestBody Document document, @RequestParam("file") MultipartFile file) throws Exception {
//        return documentService.saveDocument(document, file);
//    }


    private static String generateUUIDFileName(String originalFileName) {
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        return uuid + extension;
    }
    @PostMapping("/document/save")
    public Document handleFileAndFieldsUpload(@RequestBody DocumentDTO documentDTO) {


        try {
            // Access the file and other fields from the DTO
//            byte[] file = documentDTO.getFile();
//            String fileN = documentDTO.getFileName();
//            String filename = generateUUIDFileName(fileN);
//            //Path filePath = Paths.get(".", filename);
//            Path filePath = Paths.get("files/", filename);
//            // Save the file to disk or process it along with other fields as needed
//            FileOutputStream stream = new FileOutputStream(String.valueOf(filePath));
//            stream.write(file);
//            stream.close();

            Document document = new Document();

//          String fileLink = "<a href=\"/files/"+ documentDTO.getFileName() + "\">" + documentDTO.getFileName() + "</a>";
            String fileLink = "<a href=\"/files/" + documentDTO.getFileName() + "\" target=\"_blank\">" + documentDTO.getFileName() + "</a>";
            document.setFileName(fileLink);
            document.setUsername(documentDTO.getUsername());
            document.setStatus(DocumentStatus.valueOf(documentDTO.getStatus()));
            document.setComment(documentDTO.getComment());

            //Save to database
            documentService.saveDocument(document);
            return document;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

//    @PostMapping("/document/handlefile")
//    public String handleFileAndUsernamePost(@RequestParam String username, @RequestParam Long id, @RequestParam String status, @RequestParam String comment, @RequestBody byte[] file) {
//        // Process the file and username as needed
//        // Example: Save the file to disk
//        // Replace "path/to/save/file" with the actual path to save the file
//        // Example: Log the username
//        System.out.println("Username: " + username);
//        Path filePath = Paths.get(".", "test.jpg");
//        try {
//            Files.write(filePath, file);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return "File and username uploaded and saved successfully";
//    }



    @GetMapping("/documents")
    public List<Document> listOfDocument() {
        return documentService.getAllDocument();
    }

    @PutMapping("/document/update")
    public Document updateDocument(@RequestBody Document document) throws IOException {
        return documentService.updateDocument(document);
    }

    @DeleteMapping("/document/delete/{documentId}")
    public void deleteDocument(@PathVariable Long documentId) {
        documentService.deleteDocument(documentId);
    }

    @GetMapping("/documents/username/{username}")
    public List<Document> documentList(@PathVariable String username) {
        return documentService.getAllDocumentByUsername(username);
    }

    @GetMapping("/document/{documentId}")
    public Document documentById(@PathVariable Long documentId) {
        return documentService.getDocumentById(documentId);
    }

    @PostMapping("/updateDocument")
    public Document updateByIdAndStatus(@RequestBody DocumentUpdateDTO documentUpdateDTO){
        return documentService.updateDocument(documentUpdateDTO);
    }
}

