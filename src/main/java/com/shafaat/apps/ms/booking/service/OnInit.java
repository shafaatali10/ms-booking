package com.shafaat.apps.ms.booking.service;

import com.shafaat.apps.ms.booking.domain.Config;
import com.shafaat.apps.ms.booking.domain.Mosque;
import com.shafaat.apps.ms.booking.domain.UserInfo;
import com.shafaat.apps.ms.booking.domain.Zone;
import com.shafaat.apps.ms.booking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class OnInit {

    @Autowired
    private MosqueRepository mosqueRepository;

    @Autowired
    private ZoneRepository zoneRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ConfigRepository configRepository;

    @Autowired
    private UserInfoRepository userInfoRepository;


    @Transactional
    public void prepareData(){
        addMosques();
        addZones();
        addSession();
        addUser();
        addConfigs();
    }

    private void addMosques(){
        Mosque m = new Mosque();
        m.setMosqueId(14);
        m.setMosqueName("Masjid Darul Ghufran");
        m.setPreferred(true);


        mosqueRepository.save(m);
    }

    private void addZones(){
        List<Zone> zoneList = new ArrayList<>();
        Zone z1 = new Zone();
//        z1.setZoneCode("");
        z1.setZoneValue(26);
        z1.setDisplayName("Zone 1 (Level 1 - Front)");
        z1.setPreferred(true);

        zoneList.add(z1);

        Zone z2 = new Zone();
//        z2.setZoneCode("");
        z2.setZoneValue(27);
        z2.setDisplayName("Zone 2 (Level 1 - Back)");
        z2.setPreferred(true);

        zoneList.add(z2);

        Zone z3 = new Zone();
//        z3.setZoneCode("");
        z3.setZoneValue(28);
        z3.setDisplayName("Zone 3 (Level 2)");
        z3.setPreferred(true);

        zoneList.add(z3);

        Zone z4 = new Zone();
//        z4.setZoneCode("");
        z4.setZoneValue(29);
        z4.setDisplayName("Zone 4 (Level 3)");
        z4.setPreferred(true);

        zoneList.add(z4);

        Zone z5 = new Zone();
//        z5.setZoneCode("");
        z5.setZoneValue(30);
        z5.setDisplayName("Zone 5 (Basement)");
        z5.setPreferred(true);

        zoneList.add(z5);

        zoneRepository.saveAll(zoneList);
    }

    private void addSession(){
        // Retrieve Session and insert for DG
    }

    private void addUser(){
        UserInfo user = new UserInfo();
        user.setFullName("Shahid Afridi");
        user.setContact("xxxxxxxx");
        user.setEmail("aaa@ssss.ccc");

        userInfoRepository.save(user);
    }

    private void addConfigs(){
        Config config = new Config();
        config.setConfigCode("APP_KEY");
        config.setConfigValue("asdlajhiqu2yeoijhoaskdn");

        configRepository.save(config);
    }

}
