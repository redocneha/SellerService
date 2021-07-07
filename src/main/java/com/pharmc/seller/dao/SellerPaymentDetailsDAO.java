package com.pharmc.seller.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import com.pharmc.seller.model.PaymentDetails;

public interface SellerPaymentDetailsDAO extends JpaRepository<PaymentDetails, Long> {
	
	@Query(value="select * from seller_payment_details where sid = :sid and status = :status",nativeQuery=true)
	List<PaymentDetails> getPayments(long sid,String status);

}
