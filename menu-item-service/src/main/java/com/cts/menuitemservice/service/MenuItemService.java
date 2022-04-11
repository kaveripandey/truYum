package com.cts.menuitemservice.service;

import java.util.List;

import com.cts.menuitemservice.entity.MenuItem;

public interface MenuItemService {
	public List<MenuItem> getMenuItemListCustomer();
	public MenuItem getMenuItem(Long id);
	public boolean modifyMenuItem(Long id,MenuItem menuItem);
	public List<MenuItem> getAllMenuItemsAdmin();
}
