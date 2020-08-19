package com.kamron.drx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
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

    public Correspondent(String correspondent, List<Document> documents) {
        this.correspondent = correspondent;
        this.documents = documents;
    }

    public Correspondent() {
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getCorrespondent() {
        return correspondent;
    }

    public void setCorrespondent(String correspondent) {
        this.correspondent = correspondent;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Correspondent.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("correspondent='" + correspondent + "'")
                .toString();
    }
}
