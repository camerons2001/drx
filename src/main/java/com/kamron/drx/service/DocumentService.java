package com.kamron.drx.service;

import com.kamron.drx.model.Document;

import java.io.FileNotFoundException;

/**
 * @author Kamron Sultanov
 * @date July 15, 2020
 */

public interface DocumentService {

    Iterable<Document> findAllDocuments();

    void saveDocument(Document document);

    Document findDocumentByRegistrationId(String registrationId) throws FileNotFoundException;

    String parseThymeleafTemplate();
}
