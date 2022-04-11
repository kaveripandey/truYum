package com.cts.cartservice.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cts.cartservice.entity.Cart;
import com.cts.cartservice.entity.MenuItem;
import com.cts.cartservice.repository.CartRepository;
import com.cts.cartservice.restclient.MenuItemClient;
import com.cts.cartservice.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private MenuItemClient menuItemClient;

	@Transactional
	public boolean addCartItem(Long userId, Long menuItemId) {
		log.info("Inside addCartItem service");
		List<Long> list = this.getAllCartItems(userId);
			Cart ct = new Cart();
			ct.setUserId(userId);
			ct.setMenuItemId(menuItemId);
			Date date=new Date();
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
			String str = sdf.format(date);
			MenuItem mi=menuItemClient.getMenuItem(menuItemId);
			if(mi.isActive() && ((mi.getDateOfLaunch().equals(DateUtil.convertToDate(str))) || (mi.getDateOfLaunch()).before(DateUtil.convertToDate(str)))) {
				cartRepository.save(ct);
				return true;
			}else {
				return false;
			}
	}

	@Transactional
	public List<Long> getAllCartItems(Long userId) {
		log.info("Inside getAllCartItems service");
		return cartRepository.getAllCartItems(userId);
	}

	@Transactional
	public boolean removeCartItem(Long userId, Long menuItemId) {
		log.info("Inside removeCartItem service");
		List<Long> list = this.getAllCartItems(userId);
		if (list.contains(menuItemId)) {
			cartRepository.removeCartItem(userId, menuItemId);
			return true;
		} else {
			return false;
		}

	}

}
