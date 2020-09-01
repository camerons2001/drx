package com.kamron.drx.service;

import com.kamron.drx.model.Correspondent;

/**
 * The interface Correspondent service.
 *
 * @author Kamron Sultanov
 * @date July 18, 2020
 */
public interface CorrespondentService {

    /**
     * Find all correspondents iterable.
     *
     * @return the iterable
     */
    Iterable<Correspondent> findAllCorrespondents();
}
