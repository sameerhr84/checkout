package com.retail.ecom.checkout.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages={"com.retail"})
public class CheckoutApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(CheckoutApplication.class, args);
    }

}
