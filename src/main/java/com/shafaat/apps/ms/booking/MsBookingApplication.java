package com.shafaat.apps.ms.booking;

import com.shafaat.apps.ms.booking.service.OnInit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class MsBookingApplication {

	@Autowired
	private OnInit onInit;

	public static void main(String[] args) {
		SpringApplication.run(MsBookingApplication.class, args);
	}

	@PostConstruct
	public void prepareData(){
		onInit.prepareData();
	}

}
