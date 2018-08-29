package com.retail.ecom.checkout.bootstrap;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import com.retail.ecom.checkout.pojo.Cart;

@EnableEurekaClient
@EnableFeignClients(basePackages={"com.retail"})
@SpringBootApplication(scanBasePackages={"com.retail"})
public class CheckoutApplication {
	
	public static int cartId=1;
	public static Map<Integer,Cart> carts=new HashMap<Integer,Cart>();
	
	public static  String hostName;
	
	public static void main(String[] args) {
        SpringApplication.run(CheckoutApplication.class, args);
        
        try {
			hostName = InetAddress.getLocalHost().getHostName();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
