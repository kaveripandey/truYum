package com.cts.cartservice.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.cartservice.entity.MenuItem;

@FeignClient(name="MENU-ITEM-SERVICE",url="localhost:8081")
public interface MenuItemClient {
	
	@GetMapping("/menu-items/{id}")
	public MenuItem getMenuItem(@PathVariable("id") Long id);
}
