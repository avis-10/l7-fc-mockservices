package com.litmus7.org.l7fcmockservices.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.litmus7.org.l7fcmockservices.config.FcMockServicesProperties.Swagger.Contact;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@PropertySource(value = "classpath:swagger-docs.properties")
public class SwaggerConfig {

	@Autowired
	private FcMockServicesProperties fcMockServicesProperties;
	
	@Bean
	public Docket postApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName(fcMockServicesProperties.swagger.groupname)
				.apiInfo(apiInfo())
				.select()
				.paths(postPaths())
				.apis(apis())
				.build();
	}
	
	private Predicate<String> postPaths(){
		return Predicates.or(PathSelectors.regex(fcMockServicesProperties.swagger.path));
	}
	
	public Predicate<RequestHandler> apis(){
		return RequestHandlerSelectors.basePackage(fcMockServicesProperties.swagger.base);
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(fcMockServicesProperties.swagger.title)
				.description(fcMockServicesProperties.swagger.description)
				.termsOfServiceUrl(fcMockServicesProperties.swagger.termsOfServiceUrl)
				.contact(new Contact(fcMockServicesProperties.swagger.contact.name,fcMockServicesProperties.swagger.contact.url, fcMockServicesProperties.swagger.contact.email).toString())
				.license(fcMockServicesProperties.swagger.license)
				.licenseUrl(fcMockServicesProperties.swagger.licenseUrl)
				.version("1.0").build();
	}

}
