package com.cts.cartservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.cartservice.entity.CartResponse;
import com.cts.cartservice.entity.MenuItem;
import com.cts.cartservice.exception.CartEmptyException;
import com.cts.cartservice.restclient.MenuItemClient;
import com.cts.cartservice.service.CartService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private MenuItemClient menuItemClient;
	
	@PostMapping("/{userId}/{menuItemId}")
	public ResponseEntity<CartResponse> addCartItem(@PathVariable("userId")Long userId, @PathVariable("menuItemId") Long menuItemId) {
		log.info("Inside addCartItem controller");
		CartResponse response = new CartResponse();
		if (cartService.addCartItem(userId, menuItemId)) {
			response.setStatus("Item added to cart");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus("Item not added to cart/item is not present in menulist");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable("userId")Long userId) throws CartEmptyException{
		log.info("Inside getAllCartItems controller");
		List<Long> ids=cartService.getAllCartItems(userId);
		if(ids.size()==0) {
			throw new CartEmptyException("Cart Empty");
		}
		List<MenuItem> menuItems=new ArrayList<>();
		for(Long i:ids) {
			menuItems.add(menuItemClient.getMenuItem(i));
		}
		return menuItems;
	}
	
	@DeleteMapping("/{userId}/{menuItemId}")
	public ResponseEntity<CartResponse> removeCartItem(@PathVariable("userId")Long userId, @PathVariable("menuItemId") Long menuItemId) {
		log.info("Inside removeCartItem controller");
		//cartService.removeCartItem(userId, menuItemId);
		CartResponse response = new CartResponse();
		if (cartService.removeCartItem(userId, menuItemId)) {
			response.setStatus("Item removed from cart");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus("Item not removed from cart/item is not present cart");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
