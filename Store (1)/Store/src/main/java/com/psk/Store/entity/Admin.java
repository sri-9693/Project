package com.psk.Store.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Admin 
{
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="admin_id")
	    private int adminID;

	    @Column(name="admin_name")
	    private String adminName;
	    
	    private String email;
	    private long mobile;
	    private String password;
	    
	    public Admin()  {}

		public Admin(int adminID, String adminName, String email, long mobile, String password) {
			super();
			this.adminID = adminID;
			this.adminName = adminName;
			this.email = email;
			this.mobile = mobile;
			this.password = password;
		}

		public int getAdminID() {
			return adminID;
		}

		public void setAdminID(int adminID) {
			this.adminID = adminID;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getMobile() {
			return mobile;
		}

		public void setMobile(long mobile) {
			this.mobile = mobile;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
}
