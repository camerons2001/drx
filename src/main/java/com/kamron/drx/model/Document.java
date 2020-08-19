package com.kamron.drx.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * @author Kamron Sultanov
 * @date July 13, 2020
 */

@Entity
@Table(name = "documents")
public class Document {

    @Size(min = 2, max = 255, message = "Field registration № must be 2-255 characters long, contain letters or/with numbers and must not contain spaces")
    @Id
    @Column(name = "reg_id", nullable = false)
    private String registrationId;

    @PastOrPresent(message = "Date on this field must be in past or today")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "reg_date", nullable = false)
    private LocalDate registrationDate;

    @Size(min = 5, max = 255, message = "Field document № must be 2-255 characters long, contain letters or/with numbers and must not contain spaces")
    @Column(name = "doc_id")
    private String documentId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "doc_date")
    private LocalDate documentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "correspondent_id")
    private Correspondent correspondent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @Size(min = 1, max = 100, message = "Field subject must be 1-100 characters long")
    @Column(name = "doc_subject", nullable = false, length = 100)
    private String documentSubject;

    @Size(min = 5, max = 1000, message = "Field description must be 5-1000 characters long")
    @Column(name = "doc_description", nullable = false, length = 1000)
    private String documentDescription;

    @Future(message = "Date on this field must be tomorrow or later")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "doc_deadline")
    private LocalDate documentDeadline;

    @Column(name = "doc_authority", length = 3)
    private String documentAuthority;

    @Column(name = "doc_control", length = 3)
    private String documentControl;

    @Column(name = "doc_name", length = 50)
    private String documentName;

    @Column(name = "doc_type")
    private String documentType;

    @Lob
    @Column(name = "doc_file")
    private byte[] documentFile;

    public Document(String registrationId, LocalDate registrationDate, String documentId, LocalDate documentDate, Correspondent correspondent, Delivery delivery, String documentSubject, String documentDescription, LocalDate documentDeadline, String documentAuthority, String documentControl, String documentName, String documentType, byte[] documentFile) {
        this.registrationId = registrationId;
        this.registrationDate = registrationDate;
        this.documentId = documentId;
        this.documentDate = documentDate;
        this.correspondent = correspondent;
        this.delivery = delivery;
        this.documentSubject = documentSubject;
        this.documentDescription = documentDescription;
        this.documentDeadline = documentDeadline;
        this.documentAuthority = documentAuthority;
        this.documentControl = documentControl;
        this.documentName = documentName;
        this.documentType = documentType;
        this.documentFile = documentFile;
    }

    public Document() {
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    public Correspondent getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(Correspondent correspondent) {
        this.correspondent = correspondent;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public String getDocumentSubject() {
        return documentSubject;
    }

    public void setDocumentSubject(String documentSubject) {
        this.documentSubject = documentSubject;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public LocalDate getDocumentDeadline() {
        return documentDeadline;
    }

    public void setDocumentDeadline(LocalDate documentDeadline) {
        this.documentDeadline = documentDeadline;
    }

    public String getDocumentAuthority() {
        return documentAuthority;
    }

    public void setDocumentAuthority(String documentAuthority) {
        this.documentAuthority = documentAuthority;
    }

    public String getDocumentControl() {
        return documentControl;
    }

    public void setDocumentControl(String documentControl) {
        this.documentControl = documentControl;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public byte[] getDocumentFile() {
        return documentFile;
    }

    public void setDocumentFile(byte[] documentFile) {
        this.documentFile = documentFile;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Document.class.getSimpleName() + "[", "]")
                .add("registrationId='" + registrationId + "'")
                .add("registrationDate=" + registrationDate)
                .add("documentId='" + documentId + "'")
                .add("documentDate=" + documentDate)
                .add("correspondent=" + correspondent)
                .add("delivery=" + delivery)
                .add("documentSubject='" + documentSubject + "'")
                .add("documentDescription='" + documentDescription + "'")
                .add("documentDeadline=" + documentDeadline)
                .add("documentAuthority='" + documentAuthority + "'")
                .add("documentControl='" + documentControl + "'")
                .add("documentName='" + documentName + "'")
                .add("documentType='" + documentType + "'")
                .add("documentFile=" + Arrays.toString(documentFile))
                .toString();
    }
}
