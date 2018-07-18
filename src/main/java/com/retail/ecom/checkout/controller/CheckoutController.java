package com.retail.ecom.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.checkout.bootstrap.CheckoutApplication;
import com.retail.ecom.checkout.clients.ContentClient;
import com.retail.ecom.checkout.pojo.Cart;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private ContentClient contentClient;
	
	
	@RequestMapping("/addtocart")
    public  ResponseEntity<?>  offer(@RequestParam(value="id") String id) {
		
		contentClient.offer(id);
		
		Cart cart=new Cart();
		cart.setId(CheckoutApplication.cartId++);
		cart.getItemList().add(id);
		cart.setStatus("Pending");
		
		CheckoutApplication.carts.put(cart.getId(), cart);
		
		//return new ResponseEntity<Cart>(cart, HttpStatus.OK);
		return contentClient.offer(id);
    }
	
	@RequestMapping("/placeorder")
    public  ResponseEntity<?>  seller(@RequestParam(value="cartId") Integer cartId) {
		
		Cart cart=CheckoutApplication.carts.get(cartId);
		cart.setStatus("Placed");
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

}
