package com.shafaat.apps.ms.booking.repository;

import com.shafaat.apps.ms.booking.domain.UserInfo;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the UserInfo entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

}
