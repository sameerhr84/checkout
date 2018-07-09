package com.retail.ecom.content.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.retail.ecom.checkout.pojo.Offer;
import com.retail.ecom.checkout.pojo.Seller;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {
	
	
	@RequestMapping("/offer")
    public  ResponseEntity<?>  offer(@RequestParam(value="id") String id) {
		Offer offer =new Offer();
		offer.setId(id);
		offer.setSellerId("1"+id);
		offer.setImageUrl("https://c.shld.net/rpx/i/s/i/spin/image/spin_prod_890496812?wid=156&hei=156&qlt=90,0&resMode=sharp&op_usm=0.9,0.5,0,0");
		offer.setName("Kenmore 414301 Food Processor - Black");
		return new ResponseEntity<Offer>(offer, HttpStatus.OK);
    }
	
	@RequestMapping("/seller")
    public  ResponseEntity<?>  seller(@RequestParam(value="id") String id) {
		Seller seller=new Seller();
		seller.setId(id);
		seller.setName("Seller"+id);
		seller.setZipcode("60107");
		return new ResponseEntity<Seller>(seller, HttpStatus.OK);
    }

}
