package com.cts.menuitemservice.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.menuitemservice.entity.MenuItem;
import com.cts.menuitemservice.repository.MenuItemRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuItemServiceImpl implements MenuItemService {
	@Autowired
	private MenuItemRepository menuItemRepository;

	@Transactional
	public List<MenuItem> getMenuItemListCustomer() {
		log.info("Inside getMenuItemListCustomer serviceimpl");
		return menuItemRepository.getMenuItemListCustomer();
	}
	
	@Transactional
	public List<MenuItem> getAllMenuItemsAdmin() {
		log.info("Inside getAllMenuItemsAdmin serviceimpl");
		return menuItemRepository.getMenuItemListAdmin();
	}
	

	@Transactional
	public MenuItem getMenuItem(Long id) {
		log.info("Inside getMenuItem service");
		Optional<MenuItem> menuItem = menuItemRepository.findById(id);
		if (menuItem.isPresent()) {
			MenuItem obj = menuItem.get();
			return obj;
		} else {
			return null;
		}
	}

	@Transactional
	public boolean modifyMenuItem(Long id, MenuItem menuItem) {
		log.info("Inside modifyMenuItem service");
		// menuItemRepository.modifyMenuItem(id,menuItem);
		Optional<MenuItem> item = menuItemRepository.findById(id);
		if (item.isPresent()) {
			MenuItem mi = item.get();
			mi.setName(menuItem.getName());
			mi.setPrice(menuItem.getPrice());
			mi.setActive(menuItem.isActive());
			mi.setDateOfLaunch(menuItem.getDateOfLaunch());
			mi.setCategory(menuItem.getCategory());
			mi.setFreeDelivery(menuItem.isFreeDelivery());
			menuItemRepository.save(mi);
			return true;
		} else {
			return false;
		}
	}


	
}
