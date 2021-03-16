package com.shafaat.apps.ms.booking.web.rest;

import com.shafaat.apps.ms.booking.service.BackgroundRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private BackgroundRunner runner;

    @RequestMapping("/start")
    public String startBg() throws InterruptedException {
        if(runner.isBackgroundRunning()){
            return "Background process is already running";
        }
        runner.startBackgroudProcess();
        return "Success";
    }

    @RequestMapping("/stop")
    public String stopg() throws InterruptedException {
        runner.stopBackgroudProcess();
        return "Success";
    }

}
