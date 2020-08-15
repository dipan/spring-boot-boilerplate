package com.trafficrecorder.trafficrecorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TrafficRecorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficRecorderApplication.class, args);
	}

}
