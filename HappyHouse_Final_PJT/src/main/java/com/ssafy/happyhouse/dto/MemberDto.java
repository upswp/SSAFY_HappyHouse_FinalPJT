package com.ssafy.happyhouse.dto;

import java.sql.Date;

public class MemberDto {
	/*사용자 권한에 맞는 no*/
	private int userno;
	/*사용자 id*/
	private String userid;
	/*사용자 이름*/
	private String username;
	/*사용자 비밀번호*/
	private String userpwd;
	/*사용자 이메일*/
	private String email;
	/*사용자 주소*/
	private String address;
	/*사용자 생년월일*/
	private Date birth_date;
	/*사용자 관심 지역*/
	private String interest_area;
	/*사용자 결혼 여부*/
	private String marriage_type;
	
	public int getUserno() {
		return userno;
	}
	public void setUserno(int userno) {
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
		return "MemberDto [userno=" + userno + ", userid=" + userid + ", username=" + username + ", userpwd=" + userpwd
				+ ", email=" + email + ", address=" + address + ", birth_date=" + birth_date + ", interest_area="
				+ interest_area + ", marriage_type=" + marriage_type + "]";
	}

	
}
