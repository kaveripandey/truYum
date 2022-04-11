package com.cts.cartservice.service;

import java.util.List;

public interface CartService {
	public boolean addCartItem(Long userId, Long menuItemId);
	public List<Long> getAllCartItems(Long userId);
	public boolean removeCartItem(Long userId, Long menuItemId);
}
