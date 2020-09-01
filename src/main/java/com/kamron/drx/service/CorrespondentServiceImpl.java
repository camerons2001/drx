package com.kamron.drx.service;

import com.kamron.drx.model.Correspondent;
import com.kamron.drx.repository.CorrespondentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Correspondent service.
 *
 * @author Kamron Sultanov
 * @date July 18, 2020
 */
@Service
public class CorrespondentServiceImpl implements CorrespondentService {

    private final CorrespondentRepository correspondentRepository;

    /**
     * Instantiates a new Correspondent service.
     *
     * @param correspondentRepository the correspondent repository
     */
    @Autowired
    public CorrespondentServiceImpl(CorrespondentRepository correspondentRepository) {
        this.correspondentRepository = correspondentRepository;
    }

    /**
     * Finds all Correspondents.
     *
     * @return Correspondent
     */
    @Override
    public Iterable<Correspondent> findAllCorrespondents() {
        return correspondentRepository.findAll();
    }
}
