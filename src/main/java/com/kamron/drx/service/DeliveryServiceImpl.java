package com.kamron.drx.service;

import com.kamron.drx.model.Delivery;
import com.kamron.drx.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Kamron Sultanov
 * @date July 18, 2020
 */

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository deliveryRepository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    @Override
    public Iterable<Delivery> findAllDeliveryTypes() {
        return deliveryRepository.findAll();
    }
}
