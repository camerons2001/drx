package com.kamron.drx.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

/**
 * The type Delivery.
 *
 * @author Kamron Sultanov
 * @date July 14, 2020
 */
@Entity
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "delivery_type", length = 14)
    private String deliveryType;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    /**
     * Instantiates a new Delivery.
     *
     * @param id           the id
     * @param deliveryType the delivery type
     * @param documents    the documents
     */
    public Delivery(Byte id, String deliveryType, List<Document> documents) {
        this.id = id;
        this.deliveryType = deliveryType;
        this.documents = documents;
    }

    /**
     * Instantiates a new Delivery.
     */
    public Delivery() {
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
     * Gets delivery type.
     *
     * @return the delivery type
     */
    public String getDeliveryType() {
        return deliveryType;
    }

    /**
     * Sets delivery type.
     *
     * @param deliveryType the delivery type
     */
    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
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
    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Returns objects' string representation.
     *
     * @return string
     */
    @Override
    public String toString() {
        return new StringJoiner(", ", Delivery.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deliveryType='" + deliveryType + "'")
                .toString();
    }
}
