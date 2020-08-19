package com.kamron.drx.service;

import com.kamron.drx.DrxApplication;
import com.kamron.drx.model.Document;
import com.kamron.drx.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileNotFoundException;

/**
 * @author Kamron Sultanov
 * @date July 15, 2020
 */

@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository documentRepository;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Iterable<Document> findAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);
    }

    @Override
    public Document findDocumentByRegistrationId(String registrationId) throws FileNotFoundException {
        return documentRepository.findById(registrationId).orElseThrow(FileNotFoundException::new);
    }

    @Override
    public String parseThymeleafTemplate() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);

        Context context = new Context();
        context.setVariable("DrxApplication", DrxApplication.class);

        return templateEngine.process("dashboard", context);
    }
}
