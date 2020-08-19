package com.kamron.drx.service;

import com.kamron.drx.model.Delivery;

/**
 * @author Kamron Sultanov
 * @date July 18, 2020
 */

public interface DeliveryService {

    Iterable<Delivery> findAllDeliveryTypes();
}
