package com.cts.menuitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cts.menuitemservice.entity.MenuItem;
import com.cts.menuitemservice.entity.MenuItemResponse;
import com.cts.menuitemservice.service.MenuItemService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/menu-items")
public class MenuItemController {
	@Autowired
	private MenuItemService menuItemService;

	@GetMapping
	public List<MenuItem> getAllMenuItems() {
		log.info("Inside getAllMenuItems controller");
		return menuItemService.getMenuItemListCustomer();
	}
	@GetMapping("/admin")
	public List<MenuItem> getAllMenuItemsAdmin(){
		log.info("Inside getAllMenuItemsAdmin controller");
		return menuItemService.getAllMenuItemsAdmin();
	}

	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") Long id) {
		log.info("Inside getMenuItem controller");
		return menuItemService.getMenuItem(id);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<MenuItemResponse> modifyMenuItem(@PathVariable("id") Long id,@RequestBody MenuItem menuItem) {
		log.info("Start Modify Menu Item Controller");
		MenuItemResponse response = new MenuItemResponse();
		if (menuItemService.modifyMenuItem(id, menuItem)) {
			response.setStatus("MenuItem is Updated");
			return new ResponseEntity<MenuItemResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus("Menu Item is not updated");
			return new ResponseEntity<MenuItemResponse>(response, HttpStatus.NOT_FOUND);
		}
	}
}
