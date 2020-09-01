package com.kamron.drx.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.StringJoiner;

/**
 * The type Document.
 *
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

    /**
     * Instantiates a new Document.
     *
     * @param registrationId      the registration id
     * @param registrationDate    the registration date
     * @param documentId          the document id
     * @param documentDate        the document date
     * @param correspondent       the correspondent
     * @param delivery            the delivery
     * @param documentSubject     the document subject
     * @param documentDescription the document description
     * @param documentDeadline    the document deadline
     * @param documentAuthority   the document authority
     * @param documentControl     the document control
     * @param documentName        the document name
     * @param documentType        the document type
     * @param documentFile        the document file
     */
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

    /**
     * Instantiates a new Document.
     */
    public Document() {
    }

    /**
     * Gets registration id.
     *
     * @return the registration id
     */
    public String getRegistrationId() {
        return registrationId;
    }

    /**
     * Sets registration id.
     *
     * @param registrationId the registration id
     */
    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    /**
     * Gets registration date.
     *
     * @return the registration date
     */
    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets registration date.
     *
     * @param registrationDate the registration date
     */
    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Gets document id.
     *
     * @return the document id
     */
    public String getDocumentId() {
        return documentId;
    }

    /**
     * Sets document id.
     *
     * @param documentId the document id
     */
    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    /**
     * Gets document date.
     *
     * @return the document date
     */
    public LocalDate getDocumentDate() {
        return documentDate;
    }

    /**
     * Sets document date.
     *
     * @param documentDate the document date
     */
    public void setDocumentDate(LocalDate documentDate) {
        this.documentDate = documentDate;
    }

    /**
     * Gets correspondent.
     *
     * @return the correspondent
     */
    public Correspondent getCorrespondent() {
        return correspondent;
    }

    /**
     * Sets correspondent.
     *
     * @param correspondent the correspondent
     */
    public void setCorrespondent(Correspondent correspondent) {
        this.correspondent = correspondent;
    }

    /**
     * Gets delivery.
     *
     * @return the delivery
     */
    public Delivery getDelivery() {
        return delivery;
    }

    /**
     * Sets delivery.
     *
     * @param delivery the delivery
     */
    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    /**
     * Gets document subject.
     *
     * @return the document subject
     */
    public String getDocumentSubject() {
        return documentSubject;
    }

    /**
     * Sets document subject.
     *
     * @param documentSubject the document subject
     */
    public void setDocumentSubject(String documentSubject) {
        this.documentSubject = documentSubject;
    }

    /**
     * Gets document description.
     *
     * @return the document description
     */
    public String getDocumentDescription() {
        return documentDescription;
    }

    /**
     * Sets document description.
     *
     * @param documentDescription the document description
     */
    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    /**
     * Gets document deadline.
     *
     * @return the document deadline
     */
    public LocalDate getDocumentDeadline() {
        return documentDeadline;
    }

    /**
     * Sets document deadline.
     *
     * @param documentDeadline the document deadline
     */
    public void setDocumentDeadline(LocalDate documentDeadline) {
        this.documentDeadline = documentDeadline;
    }

    /**
     * Gets document authority.
     *
     * @return the document authority
     */
    public String getDocumentAuthority() {
        return documentAuthority;
    }

    /**
     * Sets document authority.
     *
     * @param documentAuthority the document authority
     */
    public void setDocumentAuthority(String documentAuthority) {
        this.documentAuthority = documentAuthority;
    }

    /**
     * Gets document control.
     *
     * @return the document control
     */
    public String getDocumentControl() {
        return documentControl;
    }

    /**
     * Sets document control.
     *
     * @param documentControl the document control
     */
    public void setDocumentControl(String documentControl) {
        this.documentControl = documentControl;
    }

    /**
     * Gets document name.
     *
     * @return the document name
     */
    public String getDocumentName() {
        return documentName;
    }

    /**
     * Sets document name.
     *
     * @param documentName the document name
     */
    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    /**
     * Gets document type.
     *
     * @return the document type
     */
    public String getDocumentType() {
        return documentType;
    }

    /**
     * Sets document type.
     *
     * @param documentType the document type
     */
    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    /**
     * Get document file byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getDocumentFile() {
        return documentFile;
    }

    /**
     * Sets document file.
     *
     * @param documentFile the document file
     */
    public void setDocumentFile(byte[] documentFile) {
        this.documentFile = documentFile;
    }

    /**
     * Returns objects' string representation.
     *
     * @return string
     */
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
