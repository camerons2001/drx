package com.kamron.drx.repository;

import com.kamron.drx.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Kamron Sultanov
 * @date July 15, 2020
 */

@Repository
public interface DocumentRepository extends CrudRepository<Document, String> {
}
