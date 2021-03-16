package com.shafaat.apps.ms.booking.service;

import com.shafaat.apps.ms.booking.domain.Mosque;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link Mosque}.
 */
public interface MosqueService {

    /**
     * Save a mosque.
     *
     * @param mosque the entity to save.
     * @return the persisted entity.
     */
    Mosque save(Mosque mosque);

    /**
     * Get all the mosques.
     *
     * @return the list of entities.
     */
    List<Mosque> findAll();

    /**
     * Get the "id" mosque.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Mosque> findOne(Long id);

    /**
     * Delete the "id" mosque.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
