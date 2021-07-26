package com.pharmc.seller.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pharmc.seller.model.SellerOrders;

@Repository
public interface SellerOrdersDAO extends JpaRepository<SellerOrders, Long>{

	@Query(value="select oid from seller_order_details where sid = :sid",nativeQuery=true)
	List<Long> getAllOrders(long sid);
}
