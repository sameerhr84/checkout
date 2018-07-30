package com.retail.ecom.checkout.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.retail.ecom.checkout.pojo.Inventory;

@FeignClient(name="inventory")
public interface InventoryClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/inventory/availability", produces = "application/json")
	public  Inventory  inventory(@RequestParam(value="id") String id);
    
    @RequestMapping(method = RequestMethod.GET, value = "/inventory/reservation", produces = "application/json")
    public  Inventory  reservation(@RequestParam(value="id") String id);

}
