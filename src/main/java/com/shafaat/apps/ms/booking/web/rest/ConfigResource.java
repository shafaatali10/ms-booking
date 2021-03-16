package com.shafaat.apps.ms.booking.web.rest;

import com.shafaat.apps.ms.booking.domain.Config;
import com.shafaat.apps.ms.booking.repository.ConfigRepository;
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
 * REST controller for managing {@link com.shafaat.apps.ms.booking.domain.Config}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ConfigResource {

    private final Logger log = LoggerFactory.getLogger(ConfigResource.class);

    private static final String ENTITY_NAME = "config";

    @Value("${clientApp.name}")
    private String applicationName;

    private final ConfigRepository configRepository;

    public ConfigResource(ConfigRepository configRepository) {
        this.configRepository = configRepository;
    }

    /**
     * {@code POST  /configs} : Create a new config.
     *
     * @param config the config to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new config, or with status {@code 400 (Bad Request)} if the config has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/configs")
    public ResponseEntity<Config> createConfig(@RequestBody Config config) throws Exception {
        log.debug("REST request to save Config : {}", config);
        if (config.getId() != null) {
            throw new Exception("A new config cannot already have an ID" +  ENTITY_NAME + "idexists");
        }
        Config result = configRepository.save(config);
        return ResponseEntity.created(new URI("/api/configs/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /configs} : Updates an existing config.
     *
     * @param config the config to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated config,
     * or with status {@code 400 (Bad Request)} if the config is not valid,
     * or with status {@code 500 (Internal Server Error)} if the config couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/configs")
    public ResponseEntity<Config> updateConfig(@RequestBody Config config) throws Exception {
        log.debug("REST request to update Config : {}", config);
        if (config.getId() == null) {
            throw new Exception("Invalid id" +  ENTITY_NAME + "idnull");
        }
        Config result = configRepository.save(config);
        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, config.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /configs} : get all the configs.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of configs in body.
     */
    @GetMapping("/configs")
    public List<Config> getAllConfigs() {
        log.debug("REST request to get all Configs");
        return configRepository.findAll();
    }

    /**
     * {@code GET  /configs/:id} : get the "id" config.
     *
     * @param id the id of the config to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the config, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/configs/{id}")
    public ResponseEntity<Config> getConfig(@PathVariable Long id) {
        log.debug("REST request to get Config : {}", id);
        Optional<Config> config = configRepository.findById(id);
        return ResponseEntity.ok().body(config.get());
    }

    /**
     * {@code DELETE  /configs/:id} : delete the "id" config.
     *
     * @param id the id of the config to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/configs/{id}")
    public ResponseEntity<Void> deleteConfig(@PathVariable Long id) {
        log.debug("REST request to delete Config : {}", id);
        configRepository.deleteById(id);
        return ResponseEntity.noContent().
//                headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).
                build();
    }
}
