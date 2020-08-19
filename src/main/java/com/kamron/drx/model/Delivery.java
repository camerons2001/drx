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
@Table(name = "deliveries")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column(name = "delivery_type", length = 14)
    private String deliveryType;

    @OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Document> documents = new ArrayList<>();

    public Delivery(String deliveryType, List<Document> documents) {
        this.deliveryType = deliveryType;
        this.documents = documents;
    }

    public Delivery() {
    }

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Delivery.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("deliveryType='" + deliveryType + "'")
                .toString();
    }
}
