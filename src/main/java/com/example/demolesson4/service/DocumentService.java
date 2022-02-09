package com.example.demolesson4.service;

import com.example.demolesson4.data.Document;

public interface DocumentService {
    Document addDocumentToPerson(Integer id, String passportNum, String inn);

    Document getDocumentByPersonId(Integer id);
}
