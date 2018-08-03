package com.retail.ecom.checkout.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.checkout.bootstrap.CheckoutApplication;
import com.retail.ecom.checkout.clients.ContentClient;
import com.retail.ecom.checkout.clients.InventoryClient;
import com.retail.ecom.checkout.clients.PaymentClient;
import com.retail.ecom.checkout.pojo.Cart;
import com.retail.ecom.checkout.pojo.Inventory;
import com.retail.ecom.checkout.pojo.Offer;
import com.retail.ecom.checkout.pojo.Payment;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	private ContentClient contentClient;
	
	@Autowired
	private InventoryClient inventoryClient;
	
	@Autowired
	private PaymentClient paymentClient;
	
	
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
    public  Cart  placeorder(@RequestParam(value="cartId") Integer cartId) {
		
		Cart cart=CheckoutApplication.carts.get(cartId);
		
		Payment payment = new Payment();
		payment.setCardNumber("4111111111111111");
		payment.setCardName("test card");
		payment.setExpiryDate("09/23");
		payment.setCvv("345");
		payment.setAuthAmount(100);
		
		payment=paymentClient.createpayment(payment);
		
		payment=paymentClient.authorizepayment(payment.getId());
		
		cart.setPayment(payment);
		
		cart.setStatus("Placed");
		
		return cart;
    }

}
