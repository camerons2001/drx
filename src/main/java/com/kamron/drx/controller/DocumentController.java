package com.kamron.drx.controller;

import com.kamron.drx.model.Correspondent;
import com.kamron.drx.model.Delivery;
import com.kamron.drx.model.Document;
import com.kamron.drx.service.CorrespondentServiceImpl;
import com.kamron.drx.service.DeliveryServiceImpl;
import com.kamron.drx.service.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author Kamron Sultanov
 * @date July 15, 2020
 */

@Controller
public class DocumentController {

    private final DocumentServiceImpl documentService;

    private final CorrespondentServiceImpl correspondentService;

    private final DeliveryServiceImpl deliveryService;

    @Autowired
    public DocumentController(DocumentServiceImpl documentService, CorrespondentServiceImpl correspondentService, DeliveryServiceImpl deliveryService) {
        this.documentService = documentService;
        this.correspondentService = correspondentService;
        this.deliveryService = deliveryService;
    }

    @GetMapping(path = "/Documents")
    public String listAllDocuments(Model model) {
        model.addAttribute("documents", documentService.findAllDocuments());
        return "dashboard-documents";
    }

    @GetMapping(path = "/Documents/registry")
    public String addNewDocument(Model model) {
        model.addAttribute(new Document());
        model.addAttribute("correspondents", correspondentService.findAllCorrespondents());
        model.addAttribute("deliveries", deliveryService.findAllDeliveryTypes());
        return "dashboard-document-add";
    }

    @PostMapping(path = "/Documents/registry")
    public String addNewDocumentForm(@Valid @ModelAttribute Document document,
                                     BindingResult result,
                                     @RequestParam Byte correspondentId,
                                     @RequestParam Byte deliveryId,
                                     @RequestParam("files") MultipartFile[] files) {
        try {
            if (result.hasErrors()) {
                return "dashboard-document-add";
            } else {
                for (MultipartFile file : files) {
                    Correspondent correspondent = new Correspondent();
                    correspondent.setId(correspondentId);

                    Delivery delivery = new Delivery();
                    delivery.setId(deliveryId);

                    document.setCorrespondent(correspondent);
                    document.setDelivery(delivery);
                    document.setDocumentName(file.getOriginalFilename());
                    document.setDocumentType(file.getContentType());
                    document.setDocumentFile(file.getBytes());
                    documentService.saveDocument(document);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/Documents";
    }

    @GetMapping("/Documents/document/d/{registrationId}")
    public ResponseEntity<ByteArrayResource> downloadDocument(@PathVariable String registrationId) throws FileNotFoundException {
        Document document = documentService.findDocumentByRegistrationId(registrationId);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(document.getDocumentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename\"" + document.getDocumentName() + "\"")
                .body(new ByteArrayResource(document.getDocumentFile()));
    }

    @GetMapping("/Documents/document/view/{registrationId}")
    public String getDocumentDetails(Model model, @PathVariable String registrationId) throws FileNotFoundException {
        model.addAttribute("documents", documentService.findDocumentByRegistrationId(registrationId));
        model.addAttribute("deliveries",deliveryService.findAllDeliveryTypes());
        model.addAttribute("correspondent", correspondentService.findAllCorrespondents());
        return "dashboard-document-details";
    }
}
