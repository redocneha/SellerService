package com.pharmc.seller.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="seller_details")
public class SellerDetails {
	
	    @Id
	    private long id;
	    
	    @Column(insertable = false)
	    private String name;
	    
	    @Column(insertable = false)
	    private String email;
	    
	    @Column(insertable = false)
	    private String password;
	    
	    @Column(insertable = false , name = "mobileNo")
	    private long mobileNo;
	    
	    @Column(insertable=false,name = "accountNumber")
	    private long accountNo;

		public long getId() {
			return id;
		}


		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public long getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(long mobileNo) {
			this.mobileNo = mobileNo;
		}

		public long getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(long accountNo) {
			this.accountNo = accountNo;
		}

}
