package com.kamron.drx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Correspondent.
 *
 * @author Kamron Sultanov
 * @date July 14, 2020
 */
@Entity
@Table(name = "correspondents")
public class Correspondent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "correspondent", length = 3)
    private String correspondent;

    @OneToMany(mappedBy = "correspondent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    /**
     * Instantiates a new Correspondent.
     *
     * @param correspondent the correspondent
     * @param documents     the documents
     */
    public Correspondent(String correspondent, List<Document> documents) {
        this.correspondent = correspondent;
        this.documents = documents;
    }

    /**
     * Instantiates a new Correspondent.
     */
    public Correspondent() {
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Byte getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Byte id) {
        this.id = id;
    }

    /**
     * Gets correspondent.
     *
     * @return the correspondent
     */
    public String getCorrespondent() {
        return correspondent;
    }

    /**
     * Sets correspondent.
     *
     * @param correspondent the correspondent
     */
    public void setCorrespondent(String correspondent) {
        this.correspondent = correspondent;
    }

    /**
     * Gets documents.
     *
     * @return the documents
     */
    public List<Document> getDocuments() {
        return documents;
    }

    /**
     * Sets documents.
     *
     * @param documents the documents
     */
    public void setDocuments(List<Document> documents)  {
        this.documents = documents;
    }

    /**
     * Returns objects' string representation.
     *
     * @return string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Correspondent.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("correspondent='" + correspondent + "'")
                .toString();
    }
}
