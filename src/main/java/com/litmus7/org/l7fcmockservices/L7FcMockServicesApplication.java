package com.litmus7.org.l7fcmockservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories
//@EnableEurekaClient
@PropertySource(value = "classpath:swagger-docs.properties")
public class L7FcMockServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(L7FcMockServicesApplication.class, args);
	}

}
