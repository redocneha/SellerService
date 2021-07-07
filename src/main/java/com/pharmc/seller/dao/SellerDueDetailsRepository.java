package com.pharmc.seller.dao;

import java.util.List;

import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pharmc.seller.model.SellerDueDetails;

@Repository
@Table(name="seller_due_details")
public interface SellerDueDetailsRepository extends JpaRepository<SellerDueDetails, Long> {
	
	
		 @Query(value="SELECT * FROM seller_due_details", nativeQuery = true)
		    List<SellerDueDetails> sellersDueList();
		    
	
}
