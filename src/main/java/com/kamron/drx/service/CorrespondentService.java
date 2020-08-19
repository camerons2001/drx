package com.kamron.drx.service;

import com.kamron.drx.model.Correspondent;

/**
 * @author Kamron Sultanov
 * @date July 18, 2020
 */

public interface CorrespondentService {

    Iterable<Correspondent> findAllCorrespondents();
}
