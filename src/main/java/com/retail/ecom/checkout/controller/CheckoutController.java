package com.retail.ecom.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.checkout.bootstrap.CheckoutApplication;
import com.retail.ecom.checkout.clients.ContentClient;
import com.retail.ecom.checkout.clients.InventoryClient;
import com.retail.ecom.checkout.pojo.Cart;
import com.retail.ecom.checkout.pojo.Inventory;
import com.retail.ecom.checkout.pojo.Offer;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private ContentClient contentClient;
	
	@Autowired
	private InventoryClient inventoryClient;
	
	
	@RequestMapping("/addtocart")
    public  Cart  offer(@RequestParam(value="id") String id) {
		
		Offer offer=contentClient.offer(id);
		
		Inventory inventory=inventoryClient.inventory(id);
		
		Cart cart=new Cart();
		cart.setId(CheckoutApplication.cartId++);
		cart.getItemList().add(offer);
		cart.setStatus("Pending");
		cart.setInventory(inventory);
		
		CheckoutApplication.carts.put(cart.getId(), cart);
		
		return cart;
    }
	
	@RequestMapping("/placeorder")
    public  Cart  seller(@RequestParam(value="cartId") Integer cartId) {
		
		Cart cart=CheckoutApplication.carts.get(cartId);
		cart.setStatus("Placed");
		return cart;
    }

}
