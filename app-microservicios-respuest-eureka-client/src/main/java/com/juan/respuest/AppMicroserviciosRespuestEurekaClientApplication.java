package com.juan.respuest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.juan.respuest.entity","com.juan.exam.entity","com.juan.user.entity"})
public class AppMicroserviciosRespuestEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMicroserviciosRespuestEurekaClientApplication.class, args);
	}

}
