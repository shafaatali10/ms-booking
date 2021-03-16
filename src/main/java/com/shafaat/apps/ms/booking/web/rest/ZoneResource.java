package com.shafaat.apps.ms.booking.web.rest;

import com.shafaat.apps.ms.booking.domain.Zone;
import com.shafaat.apps.ms.booking.repository.ZoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.shafaat.apps.ms.booking.domain.Zone}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ZoneResource {

    private final Logger log = LoggerFactory.getLogger(ZoneResource.class);

    private static final String ENTITY_NAME = "zone";

    @Value("${clientApp.name}")
    private String applicationName;

    private final ZoneRepository zoneRepository;

    public ZoneResource(ZoneRepository zoneRepository) {
        this.zoneRepository = zoneRepository;
    }

    /**
     * {@code POST  /zones} : Create a new zone.
     *
     * @param zone the zone to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new zone, or with status {@code 400 (Bad Request)} if the zone has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/zones")
    public ResponseEntity<Zone> createZone(@RequestBody Zone zone) throws Exception {
        log.debug("REST request to save Zone : {}", zone);
        if (zone.getId() != null) {
            throw new Exception("A new zone cannot already have an ID" +   ENTITY_NAME + "idexists");
        }
        Zone result = zoneRepository.save(zone);
        return ResponseEntity.created(new URI("/api/zones/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /zones} : Updates an existing zone.
     *
     * @param zone the zone to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated zone,
     * or with status {@code 400 (Bad Request)} if the zone is not valid,
     * or with status {@code 500 (Internal Server Error)} if the zone couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/zones")
    public ResponseEntity<Zone> updateZone(@RequestBody Zone zone) throws Exception {
        log.debug("REST request to update Zone : {}", zone);
        if (zone.getId() == null) {
            throw new Exception("Invalid id" +  ENTITY_NAME + "idnull");
        }
        Zone result = zoneRepository.save(zone);
        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, zone.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /zones} : get all the zones.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zones in body.
     */
    @GetMapping("/zones")
    public List<Zone> getAllZones() {
        log.debug("REST request to get all Zones");
        return zoneRepository.findAll();
    }

    /**
     * {@code GET  /zones/:id} : get the "id" zone.
     *
     * @param id the id of the zone to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zone, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/zones/{id}")
    public ResponseEntity<Zone> getZone(@PathVariable Long id) {
        log.debug("REST request to get Zone : {}", id);
        Optional<Zone> zone = zoneRepository.findById(id);
        return ResponseEntity.ok().body(zone.get());
    }

    /**
     * {@code DELETE  /zones/:id} : delete the "id" zone.
     *
     * @param id the id of the zone to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/zones/{id}")
    public ResponseEntity<Void> deleteZone(@PathVariable Long id) {
        log.debug("REST request to delete Zone : {}", id);
        zoneRepository.deleteById(id);
        return ResponseEntity.noContent().
//                headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).
                build();
    }
}
