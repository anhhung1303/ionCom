package com.project.ioncom.model;

import java.util.List;

import com.project.ioncom.database.dao.ChatDAO;

public class PhanUng {
	private int id;
	private List<Chat> danhSachChatVao;
	private List<Chat> danhSachChatRa;
	private String dieuKien;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Chat> getDanhSachChatVao() {
		return danhSachChatVao;
	}
	
	public void setDanhSachChatVao(List<Chat> danhSachChatVao) {
		this.danhSachChatVao = danhSachChatVao;
	}
	
	public List<Chat> getDanhSachChatRa() {
		return danhSachChatRa;
	}
	
	public void setDanhSachChatRa(List<Chat> danhSachChatRa) {
		this.danhSachChatRa = danhSachChatRa;
	}
	
	public String getChatVao(){
		String result = "";
		for (Chat chatVao : danhSachChatVao){
			result += chatVao.getTen() + " + ";
		}
		result = result.substring(0, result.length() - 3);

		return result;
	}
	
	public void setChatVao(String xauChatVao){
		final String splitSemiColonStr = " \\+ ";
		String [] splitStr = xauChatVao.split(splitSemiColonStr);
		ChatDAO dao = new ChatDAO();
		for (String subStr : splitStr){
			//TODO
		}
	}
	
	public String getChatRa(){
		String result = "";
		for (Chat chatRa : danhSachChatRa){
			result += chatRa.getTen() + " + ";
		}
		result = result.substring(0, result.length() - 3);

		return result;
	}
	
	public void setChatRa(String xauChatRa){
		final String splitSemiColonStr = " \\+ ";
		String [] splitStr = xauChatRa.split(splitSemiColonStr);
		ChatDAO dao = new ChatDAO();
		for (String subStr : splitStr){
			//TODO
		}
	}
	
	public String getDieuKien() {
		return dieuKien;
	}
	
	public void setDieuKien(String dieuKien) {
		this.dieuKien = dieuKien;
	}
}
