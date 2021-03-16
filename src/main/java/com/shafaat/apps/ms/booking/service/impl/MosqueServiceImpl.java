package com.shafaat.apps.ms.booking.service.impl;

import com.shafaat.apps.ms.booking.service.MosqueService;
import com.shafaat.apps.ms.booking.domain.Mosque;
import com.shafaat.apps.ms.booking.repository.MosqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Mosque}.
 */
@Service
@Transactional
public class MosqueServiceImpl implements MosqueService {

    private final Logger log = LoggerFactory.getLogger(MosqueServiceImpl.class);

    private final MosqueRepository mosqueRepository;

    public MosqueServiceImpl(MosqueRepository mosqueRepository) {
        this.mosqueRepository = mosqueRepository;
    }

    /**
     * Save a mosque.
     *
     * @param mosque the entity to save.
     * @return the persisted entity.
     */
    @Override
    public Mosque save(Mosque mosque) {
        log.debug("Request to save Mosque : {}", mosque);
        return mosqueRepository.save(mosque);
    }

    /**
     * Get all the mosques.
     *
     * @return the list of entities.
     */
    @Override
    @Transactional(readOnly = true)
    public List<Mosque> findAll() {
        log.debug("Request to get all Mosques");
        return mosqueRepository.findAll();
    }

    /**
     * Get one mosque by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Mosque> findOne(Long id) {
        log.debug("Request to get Mosque : {}", id);
        return mosqueRepository.findById(id);
    }

    /**
     * Delete the mosque by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Mosque : {}", id);
        mosqueRepository.deleteById(id);
    }
}
