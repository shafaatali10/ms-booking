package com.shafaat.apps.ms.booking.repository;

import com.shafaat.apps.ms.booking.domain.Mosque;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Mosque entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MosqueRepository extends JpaRepository<Mosque, Long> {

}
