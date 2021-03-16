package com.shafaat.apps.ms.booking.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class BackgroundRunner {

    private AtomicBoolean cancelInitiated = new AtomicBoolean(false);
    private AtomicBoolean isFirstLoad = new AtomicBoolean(true);

    //private AtomicBoolean inProgress = new AtomicBoolean(false);


    @Async("threadPoolTaskExecutor")
    public void startBackgroudProcess() throws InterruptedException {

        isFirstLoad.set(false);
        cancelInitiated.set(false);

        while( true ){
            if( cancelInitiated.get() ){
                break;
            }
            System.out.println("Booooooom");
            Thread.sleep(10000);
        }
    }

    public void stopBackgroudProcess() {
        cancelInitiated.set(true);
    }

    public boolean isBackgroundRunning(){
        return !cancelInitiated.get() && !isFirstLoad.get();
    }
}
