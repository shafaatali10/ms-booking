package com.shafaat.apps.ms.booking.web.rest;

import com.shafaat.apps.ms.booking.domain.UserInfo;
import com.shafaat.apps.ms.booking.repository.UserInfoRepository;

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
 * REST controller for managing {@link com.shafaat.apps.ms.booking.domain.UserInfo}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class UserInfoResource {

    private final Logger log = LoggerFactory.getLogger(UserInfoResource.class);

    private static final String ENTITY_NAME = "userInfo";

    @Value("${clientApp.name}")
    private String applicationName;

    private final UserInfoRepository userInfoRepository;

    public UserInfoResource(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    /**
     * {@code POST  /user-infos} : Create a new userInfo.
     *
     * @param userInfo the userInfo to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userInfo, or with status {@code 400 (Bad Request)} if the userInfo has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-infos")
    public ResponseEntity<UserInfo> createUserInfo(@RequestBody UserInfo userInfo) throws Exception {
        log.debug("REST request to save UserInfo : {}", userInfo);
        if (userInfo.getId() != null) {
            throw new Exception("A new userInfo cannot already have an ID" + ENTITY_NAME + "idexists");
        }
        UserInfo result = userInfoRepository.save(userInfo);
        return ResponseEntity.created(new URI("/api/user-infos/" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-infos} : Updates an existing userInfo.
     *
     * @param userInfo the userInfo to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userInfo,
     * or with status {@code 400 (Bad Request)} if the userInfo is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userInfo couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-infos")
    public ResponseEntity<UserInfo> updateUserInfo(@RequestBody UserInfo userInfo) throws Exception {
        log.debug("REST request to update UserInfo : {}", userInfo);
        if (userInfo.getId() == null) {
            throw new Exception("Invalid id" +  ENTITY_NAME + "idnull");
        }
        UserInfo result = userInfoRepository.save(userInfo);
        return ResponseEntity.ok()
//            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userInfo.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-infos} : get all the userInfos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userInfos in body.
     */
    @GetMapping("/user-infos")
    public List<UserInfo> getAllUserInfos() {
        log.debug("REST request to get all UserInfos");
        return userInfoRepository.findAll();
    }

    /**
     * {@code GET  /user-infos/:id} : get the "id" userInfo.
     *
     * @param id the id of the userInfo to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userInfo, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-infos/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable Long id) {
        log.debug("REST request to get UserInfo : {}", id);
        Optional<UserInfo> userInfo = userInfoRepository.findById(id);
        return ResponseEntity.ok().body(userInfo.get());
    }

    /**
     * {@code DELETE  /user-infos/:id} : delete the "id" userInfo.
     *
     * @param id the id of the userInfo to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-infos/{id}")
    public ResponseEntity<Void> deleteUserInfo(@PathVariable Long id) {
        log.debug("REST request to delete UserInfo : {}", id);
        userInfoRepository.deleteById(id);
        return ResponseEntity.noContent()
//                .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                .build();
    }
}
