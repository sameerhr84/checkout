package com.retail.ecom.checkout.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="content")
public interface ContentClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/content/offer?id=1", produces = "application/json")
    public  ResponseEntity<?>  offer(@RequestParam(value="id") String id);

}
