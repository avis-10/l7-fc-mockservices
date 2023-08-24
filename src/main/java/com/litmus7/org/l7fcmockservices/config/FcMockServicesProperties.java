package com.litmus7.org.l7fcmockservices.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Configuration
@Setter @Getter
@PropertySource(value = "classpath:fcmockservices.properties")
@ConfigurationProperties(prefix = "fcmockservices")
@ToString
public class FcMockServicesProperties {
	
	/* Setting Swagger Properties */
	public Swagger swagger;
	
	@Getter @Setter
	@ConfigurationProperties(prefix = "swagger")
	@AllArgsConstructor
	@NoArgsConstructor
	@ToString
	public static class Swagger{
		
		public String groupname;
		public String path;
		public String base;
		public String title;
		public String description;
		public String termsOfServiceUrl;
		public String license;
		public String licenseUrl;
		
		public Contact contact;
		
		/* Setting the Contact Properties */
		@Getter @Setter
		@ConfigurationProperties(prefix = "contact")
		@AllArgsConstructor
		@NoArgsConstructor
		@ToString
		public static class Contact {
			
			public String name;
			public String url;
			public String email;
		}
		
	}

}
