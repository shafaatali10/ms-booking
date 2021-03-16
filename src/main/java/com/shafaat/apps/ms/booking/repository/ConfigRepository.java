package com.shafaat.apps.ms.booking.repository;

import com.shafaat.apps.ms.booking.domain.Config;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Config entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {

}
