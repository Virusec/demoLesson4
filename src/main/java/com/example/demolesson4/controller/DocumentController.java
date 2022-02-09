package com.example.demolesson4.controller;

import com.example.demolesson4.data.Document;
import com.example.demolesson4.service.DocumentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/get/person/{id}/document")
    public Document getPersonDocument(@PathVariable("id") Integer id) {
        return documentService.getDocumentByPersonId(id);
    }

    @GetMapping("/post/person/{id}/document")
    public Document addDocumentToPerson(@PathVariable("id") Integer id, @RequestParam("passportNum") String passportNum, @RequestParam("inn") String inn) {
        return documentService.addDocumentToPerson(id, passportNum, inn);
    }
}
