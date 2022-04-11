package com.cts.menuitemservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cts.menuitemservice.entity.MenuItem;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long>{
	@Query("select m from MenuItem m where m.active=true and m.dateOfLaunch<=cast(current_timestamp() as date)")
	public List<MenuItem> getMenuItemListCustomer();
	
	@Query("select m from MenuItem m")
	public List<MenuItem> getMenuItemListAdmin();
}
