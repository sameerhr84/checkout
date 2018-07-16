package com.retail.ecom.checkout.bootstrap;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.retail.ecom.checkout.pojo.Cart;


@SpringBootApplication(scanBasePackages={"com.retail"})
public class CheckoutApplication {
	
	public static int cartId=1;
	public static Map<Integer,Cart> carts=new HashMap<Integer,Cart>();
	public static void main(String[] args) {
        SpringApplication.run(CheckoutApplication.class, args);
    }

}
