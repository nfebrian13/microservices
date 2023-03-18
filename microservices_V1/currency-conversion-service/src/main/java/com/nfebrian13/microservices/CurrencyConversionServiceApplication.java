package com.nfebrian13.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.nfebrian13.microservices.configuration.LocalRibbonClientConfiguration;

@SpringBootApplication
@EnableFeignClients("com.nfebrian13.microservices")
@RibbonClient(name = "currency-conversion-service", configuration = LocalRibbonClientConfiguration.class)

public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}
