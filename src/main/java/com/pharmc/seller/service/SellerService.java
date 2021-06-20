package com.pharmc.seller.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pharmc.seller.dao.SellerDAO;
import com.pharmc.seller.model.SellerDetails;
import com.pharmc.seller.model.SellerLoginRequest;
import com.pharmc.seller.model.SellerLoginResponse;
import com.pharmc.seller.utils.SellerServiceError;

@Service
public class SellerService {
	
	@Autowired
	private SellerDAO sellerDao;
	
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

}
