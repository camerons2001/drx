package com.kamron.drx.service;

import com.kamron.drx.model.Document;

import java.io.FileNotFoundException;

/**
 * The interface Document service.
 *
 * @author Kamron Sultanov
 * @date July 15, 2020
 */
public interface DocumentService {

    /**
     * Find all documents iterable.
     *
     * @return the iterable
     */
    Iterable<Document> findAllDocuments();

    /**
     * Save document.
     *
     * @param document the document
     */
    void saveDocument(Document document);

    /**
     * Find document by registration id document.
     *
     * @param registrationId the registration id
     * @return the document
     * @throws FileNotFoundException the file not found exception
     */
    Document findDocumentByRegistrationId(String registrationId) throws FileNotFoundException;
}
