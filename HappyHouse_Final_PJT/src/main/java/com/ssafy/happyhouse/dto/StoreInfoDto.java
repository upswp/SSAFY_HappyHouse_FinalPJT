package com.ssafy.happyhouse.dto;

public class StoreInfoDto { // 상가정보
	private int storeno;
	private String storename;
	private String branchname;//브랜치
	private String bigcode;
	private String bigname;
	private String midcode;
	private String midname;
	private String smallcode;
	private String smallname;
	private String sidocode;
	private String sidoname;
	private String gungucode;
	private String gunguname;
	private String dongcode;
	private String dongname;
	private String doroaddr;
	private double lon; // 경도
	private double lat; // 위도
	public int getStoreno() {
		return storeno;
	}
	public void setStoreno(int storeno) {
		this.storeno = storeno;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public String getBigcode() {
		return bigcode;
	}
	public void setBigcode(String bigcode) {
		this.bigcode = bigcode;
	}
	public String getBigname() {
		return bigname;
	}
	public void setBigname(String bigname) {
		this.bigname = bigname;
	}
	public String getMidcode() {
		return midcode;
	}
	public void setMidcode(String midcode) {
		this.midcode = midcode;
	}
	public String getMidname() {
		return midname;
	}
	public void setMidname(String midname) {
		this.midname = midname;
	}
	public String getSmallcode() {
		return smallcode;
	}
	public void setSmallcode(String smallcode) {
		this.smallcode = smallcode;
	}
	public String getSmallname() {
		return smallname;
	}
	public void setSmallname(String smallname) {
		this.smallname = smallname;
	}
	public String getSidocode() {
		return sidocode;
	}
	public void setSidocode(String sidocode) {
		this.sidocode = sidocode;
	}
	public String getSidoname() {
		return sidoname;
	}
	public void setSidoname(String sidoname) {
		this.sidoname = sidoname;
	}
	public String getGungucode() {
		return gungucode;
	}
	public void setGungucode(String gungucode) {
		this.gungucode = gungucode;
	}
	public String getGunguname() {
		return gunguname;
	}
	public void setGunguname(String gunguname) {
		this.gunguname = gunguname;
	}
	public String getDongcode() {
		return dongcode;
	}
	public void setDongcode(String dongcode) {
		this.dongcode = dongcode;
	}
	public String getDongname() {
		return dongname;
	}
	public void setDongname(String dongname) {
		this.dongname = dongname;
	}
	public String getDoroaddr() {
		return doroaddr;
	}
	public void setDoroaddr(String doroaddr) {
		this.doroaddr = doroaddr;
	}
	public double getLon() {
		return lon;
	}
	public void setLon(double lon) {
		this.lon = lon;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
}