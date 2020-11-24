package com.ssafy.happyhouse.dto;

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
	private String yy;
	private String mm;
	private String dd;
	/*사용자 관심 지역*/
	private String interest_area;
	/*사용자 결혼 여부*/
	private String marriage_type;
	/*사용자 고유 번호 no*/
	private int no;
	
	
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
	public String getYy() {
		return yy;
	}
	public void setYy(String yy) {
		this.yy = yy;
	}
	public String getMm() {
		return mm;
	}
	public void setMm(String mm) {
		this.mm = mm;
	}
	public String getDd() {
		return dd;
	}
	public void setDd(String dd) {
		this.dd = dd;
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
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "MemberDto [userno=" + userno + ", userid=" + userid + ", username=" + username + ", userpwd=" + userpwd
				+ ", email=" + email + ", address=" + address + ", yy=" + yy + ", mm=" + mm + ", dd=" + dd
				+ ", interest_area=" + interest_area + ", marriage_type=" + marriage_type + ", no=" + no + "]";
	}

	
	
	
}
