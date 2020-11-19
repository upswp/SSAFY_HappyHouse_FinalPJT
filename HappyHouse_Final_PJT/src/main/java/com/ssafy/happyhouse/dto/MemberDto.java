package com.ssafy.happyhouse.dto;

import java.sql.Date;

public class MemberDto {
	private String userno;
	private String userid;
	private String username;
	private String userpwd;
	private String email;
	private String address;
	private Date birth_date;
	private String interest_area;
	private String marriage_type;
	public MemberDto(String userno, String userid, String username, String userpwd, String email, String address,
			Date birth_date, String interest_area, String marriage_type) {
		super();
		this.userno = userno;
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.email = email;
		this.address = address;
		this.birth_date = birth_date;
		this.interest_area = interest_area;
		this.marriage_type = marriage_type;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(Date birth_date) {
		this.birth_date = birth_date;
	}
	public String getInterest_area() {
		return interest_area;
	}
	public void setInterest_area(String interest_area) {
		this.interest_area = interest_area;
	}
	public String getMarriage_type() {
		return marriage_type;
	}
	public void setMarriage_type(String marriage_type) {
		this.marriage_type = marriage_type;
	}
	@Override
	public String toString() {
		return "MemberDto [userid=" + userid + ", username=" + username + ", birth_date=" + birth_date
				+ ", interest_area=" + interest_area + ", marriage_type=" + marriage_type + "]";
	}
	
	

}
