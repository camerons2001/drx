package com.kamron.drx.service;

import com.kamron.drx.model.Document;
import com.kamron.drx.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;

/**
 * The type Document service.
 *
 * @author Kamron Sultanov
 * @date July 15, 2020
 */
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    /**
     * Instantiates a new Document service.
     *
     * @param documentRepository the document repository
     */
    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    /**
     * Finds all Documents.
     *
     * @return Documents
     */
    @Override
    public Iterable<Document> findAllDocuments() {
        return documentRepository.findAll();
    }

    /**
     * Saves document.
     */
    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    /**
     * Finds document by registration id.
     *
     * @param registrationId the registration id
     * @return optional document.
     * @throws FileNotFoundException the file not found exception
     */
    @Override
    public Document findDocumentByRegistrationId(String registrationId) throws FileNotFoundException {
        return documentRepository.findById(registrationId).orElseThrow(FileNotFoundException::new);
    }
}
