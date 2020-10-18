package com.juan.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories
@EntityScan({"com.juan.exam.entity"})
public class AppMicroserviciosUserGeneric1Application {

	public static void main(String[] args) {
		SpringApplication.run(AppMicroserviciosUserGeneric1Application.class, args);
	}

}
