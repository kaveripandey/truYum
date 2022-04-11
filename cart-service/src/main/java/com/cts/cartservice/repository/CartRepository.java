package com.cts.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cts.cartservice.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {

	@Query("select c.menuItemId from Cart c where c.userId=:userId")
	public List<Long> getAllCartItems(@Param("userId")Long userId);
	
	@Modifying
	@Query(nativeQuery = true, value = "delete from cart c where c.user_id=:userId and c.item_id=:itemId")
	public void removeCartItem(@Param("userId") Long userId, @Param("itemId") Long itemId);
	

}
