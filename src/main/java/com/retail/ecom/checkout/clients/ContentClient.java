package com.retail.ecom.checkout.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.retail.ecom.checkout.pojo.Offer;

@FeignClient(name="content")
public interface ContentClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/content/offer?id=1", produces = "application/json")
    public  Offer  offer(@RequestParam(value="id") String id);

}
