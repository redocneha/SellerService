package com.pharmc.seller.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharmc.seller.dao.SellerDAO;
import com.pharmc.seller.dao.SellerDueDetailsRepository;
import com.pharmc.seller.dao.SellerOrdersDAO;
import com.pharmc.seller.dao.SellerPaymentDetailsDAO;
import com.pharmc.seller.model.PaymentDetails;
import com.pharmc.seller.model.SellerDetails;
import com.pharmc.seller.model.SellerDueDetails;
import com.pharmc.seller.model.SellerLoginRequest;
import com.pharmc.seller.model.SellerLoginResponse;
import com.pharmc.seller.model.SellerOrders;
import com.pharmc.seller.utils.SellerServiceError;

@Service
public class SellerService {
	
	@Autowired
	private SellerDAO sellerDao;
	
	@Autowired
	private SellerOrdersDAO sellerOrdersDao;
	
	@Autowired
	private SellerPaymentDetailsDAO sellerPaymentsDao;
	
	@Autowired
	private SellerDueDetailsRepository sellerDueDao;
	
	@SuppressWarnings("deprecation")
	public SellerLoginResponse checkCredentials(SellerLoginRequest sellerLoginRequest) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		SellerDetails sellerDetails = sellerDao.getSeller(sellerLoginRequest.getEmail());
		if(sellerDetails!=null) {
			if(encoder.matches(sellerLoginRequest.getPassword(), sellerDetails.getPassword())) {
				return new SellerLoginResponse(sellerDetails.getId(),null);
			}
			return new SellerLoginResponse(new Long(0),new SellerServiceError(101, "Invalid Credentials", "Password entered by the user is wrong"));
		}
		return new SellerLoginResponse(new Long(0),new SellerServiceError(102, "Invalid Email", "Email is not registered"));
	}
	
	public List<SellerDueDetails> getAllDueDetails(){
		SellerDueDetails n = new SellerDueDetails();
		n.setCreditableAmount(1234.32);
		n.setSid(1);
		sellerDueDao.save(n);
		n.setCreditableAmount(1234.32);
		n.setSid(2);
		sellerDueDao.save(n);
		List<SellerDueDetails> response = sellerDueDao.sellersDueList();
		return response;
	    	
	}

	public List<SellerOrders> getOrders(long sid) {
		// TODO Auto-generated method stub	
		return sellerOrdersDao.getAllOrders(sid);
	}

    public List<PaymentDetails> getPayments(long sid, String status){
    	return sellerPaymentsDao.getPayments(sid, status);
    }
}
