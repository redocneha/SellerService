package com.pharmc.seller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharmc.seller.model.SellerDetails;
@Repository
public interface SellerDAO extends JpaRepository<SellerDetails,Long>{
    @Query(value= "SELECT * FROM seller_details user WHERE user.email = :email", nativeQuery = true)
	SellerDetails getSeller(String email);
}
