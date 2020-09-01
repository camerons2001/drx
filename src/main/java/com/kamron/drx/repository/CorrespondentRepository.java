package com.kamron.drx.repository;

import com.kamron.drx.model.Correspondent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Correspondent repository.
 *
 * @author Kamron Sultanov
 * @date July 15, 2020
 */
@Repository
public interface CorrespondentRepository extends CrudRepository<Correspondent, Byte> {
}
