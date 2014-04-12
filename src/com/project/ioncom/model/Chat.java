package com.project.ioncom.model;

public class Chat {
	final static public int TRANG_THAI_KHI = 1;
	final static public int TRANG_THAI_KET_TUA = 2;
	final static public int TRANG_THAI_CHAT_TAN = 3;
	
	private int id;
	private String ten;
	private String trangThai;
	private String mau;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public String getMau() {
		return mau;
	}
	public void setMau(String mau) {
		this.mau = mau;
	}
}
