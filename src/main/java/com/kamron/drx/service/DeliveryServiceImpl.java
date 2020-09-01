package com.kamron.drx.service;

import com.kamron.drx.model.Delivery;
import com.kamron.drx.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Delivery service.
 *
 * @author Kamron Sultanov
 * @date July 18, 2020
 */
@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    /**
     * Instantiates a new Delivery service.
     *
     * @param deliveryRepository the delivery repository
     */
    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    /**
     * Finds all Deliveries.
     *
     * @return Deliveries
     */
    @Override
    public Iterable<Delivery> findAllDeliveryTypes() {
        return deliveryRepository.findAll();
    }
}
