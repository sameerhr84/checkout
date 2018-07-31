package com.retail.ecom.checkout.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.retail.ecom.checkout.pojo.Payment;

@FeignClient(name="payment")
public interface PaymentClient {

    @RequestMapping(method = RequestMethod.POST, value = "/payment/createpayment",consumes  = "application/json", produces = "application/json")
	public  Payment  createpayment(@RequestBody Payment payment);
    
    @RequestMapping(method = RequestMethod.GET, value = "/payment/authorizepayment", produces = "application/json")
    public  Payment  authorizepayment(@RequestParam(value="id") Integer id);
}
