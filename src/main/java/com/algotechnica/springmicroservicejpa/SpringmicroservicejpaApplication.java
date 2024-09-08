package com.algotechnica.springmicroservicejpa;

import org.apache.olingo.odata2.api.ODataServiceFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

import com.algotechnica.springmicroservicejpa.entities.AddressODataAgent;
import com.algotechnica.springmicroservicejpa.entities.VendorODataAgent;

@SpringBootApplication(scanBasePackages = "com.algotechnica.springmicroservicejpa")
@EnableJpaRepositories(basePackages = "com.algotechnica.springmicroservicejpa")
@EntityScan(basePackages = "com.algotechnica.springmicroservicejpa") 
@ServletComponentScan(basePackages = "com.algotechnica.springmicroservicejpa")
@EnableAsync
public class SpringmicroservicejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmicroservicejpaApplication.class, args);
	}
	@Bean(name="com.anubhavtrainings.demo.processor.MyODataServiceFactory")
	public ODataServiceFactory getServiceFactory(){
		return new com.algotechnica.springmicroservicejpa.processor.MyODataServiceFactory("com.algotechnica.springmicroservicejpa");
	}
	
	@Bean(name="com.algotechnica.springmicroservicejpa.entities.VendorODataAgent")
	public VendorODataAgent vendorODataAgent(){
		return new VendorODataAgent();
	}
	
	@Bean(name="com.algotechnica.springmicroservicejpa.entities.AddressODataAgent")
	public AddressODataAgent addressODataAgent(){
		return new AddressODataAgent();
	}

}
