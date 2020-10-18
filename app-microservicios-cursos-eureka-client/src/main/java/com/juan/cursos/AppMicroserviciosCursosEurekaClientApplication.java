package com.juan.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.juan.user.entity","com.juan.cursos.entity","com.juan.exam.entity"})
public class AppMicroserviciosCursosEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppMicroserviciosCursosEurekaClientApplication.class, args);
	}

}
