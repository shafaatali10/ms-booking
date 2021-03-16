package com.shafaat.apps.ms.booking.web.rest;

import com.shafaat.apps.ms.booking.domain.Mosque;
import com.shafaat.apps.ms.booking.service.MosqueService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.shafaat.apps.ms.booking.domain.Mosque}.
 */
@RestController
@RequestMapping("/api")
public class MosqueResource {

    private final Logger log = LoggerFactory.getLogger(MosqueResource.class);

    private static final String ENTITY_NAME = "mosque";

    @Value("${clientApp.name}")
    private String applicationName;

    private final MosqueService mosqueService;

    public MosqueResource(MosqueService mosqueService) {
        this.mosqueService = mosqueService;
    }

    /**
     * {@code POST  /mosques} : Create a new mosque.
     *
     * @param mosque the mosque to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mosque, or with status {@code 400 (Bad Request)} if the mosque has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mosques")
    public ResponseEntity<Mosque> createMosque(@RequestBody Mosque mosque) throws Exception {
        log.debug("REST request to save Mosque : {}", mosque);
        if (mosque.getId() != null) {
            //throw new BadRequestAlertException("A new mosque cannot already have an ID", ENTITY_NAME, "idexists");
            throw new Exception("A new mosque cannot already have an ID");
        }
        Mosque result = mosqueService.save(mosque);
        return ResponseEntity.created(new URI("/api/mosques/" + result.getId()))
            //.headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mosques} : Updates an existing mosque.
     *
     * @param mosque the mosque to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mosque,
     * or with status {@code 400 (Bad Request)} if the mosque is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mosque couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mosques")
    public ResponseEntity<Mosque> updateMosque(@RequestBody Mosque mosque) throws Exception {
        log.debug("REST request to update Mosque : {}", mosque);
        if (mosque.getId() == null) {
            throw new Exception("Invalid id" + ENTITY_NAME + "idnull");
        }
        Mosque result = mosqueService.save(mosque);
        return ResponseEntity.ok()
            //.headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mosque.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mosques} : get all the mosques.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mosques in body.
     */
    @GetMapping("/mosques")
    public List<Mosque> getAllMosques() {
        log.debug("REST request to get all Mosques");
        return mosqueService.findAll();
    }

    /**
     * {@code GET  /mosques/:id} : get the "id" mosque.
     *
     * @param id the id of the mosque to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mosque, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mosques/{id}")
    public ResponseEntity<Mosque> getMosque(@PathVariable Long id) {
        log.debug("REST request to get Mosque : {}", id);
        Optional<Mosque> mosque = mosqueService.findOne(id);
        return ResponseEntity.ok().body(mosque.get());

        //return ResponseUtil.wrapOrNotFound(mosque);
    }

    /**
     * {@code DELETE  /mosques/:id} : delete the "id" mosque.
     *
     * @param id the id of the mosque to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mosques/{id}")
    public ResponseEntity<Void> deleteMosque(@PathVariable Long id) {
        log.debug("REST request to delete Mosque : {}", id);
        mosqueService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
