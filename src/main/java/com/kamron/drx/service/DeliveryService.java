package com.kamron.drx.service;

import com.kamron.drx.model.Delivery;

/**
 * The interface Delivery service.
 *
 * @author Kamron Sultanov
 * @date July 18, 2020
 */
public interface DeliveryService {

    /**
     * Find all delivery types iterable.
     *
     * @return the iterable
     */
    Iterable<Delivery> findAllDeliveryTypes();
}
