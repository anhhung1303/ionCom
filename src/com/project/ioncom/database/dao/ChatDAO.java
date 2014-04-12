package com.project.ioncom.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.ioncom.model.Chat;

public class ChatDAO {
	final public static String BANG_CHAT = "chat";
	
	public static final String COT_ID = "id";
	public static final String COT_TEN = "ten";
	public static final String COT_TRANG_THAI = "trang_thai";
	public static final String COT_MAU = "mau";
	
	public boolean exists(Chat chat, SQLiteDatabase db) {
		Cursor conTro = db.query(BANG_CHAT, new String[] {COT_ID}, COT_ID + "= ?", 
				new String[] { chat.getId() + "" }, null, null, null);
		boolean result = conTro.moveToFirst();
		conTro.close();
		return result;
	}
	
	public void reload(Chat chat, SQLiteDatabase db) {
		Cursor conTro = db.query(BANG_CHAT, new String[] {"*"}, COT_ID + "= ?", 
				new String[] { chat.getId() + "" }, null, null, null);
		if (conTro.moveToFirst()) {
			chat = conTroDenChat(conTro);
		}
		conTro.close();
	}
	
	public Chat loadWithName(String ten, SQLiteDatabase db) {
		Chat chat = null;
		Cursor conTro = db.query(BANG_CHAT, new String[] {"*"}, COT_TEN + "= ?", 
				new String[] { ten }, null, null, null);
		if (conTro.moveToFirst()) {
			chat = conTroDenChat(conTro);
		}
		conTro.close();
		return chat;
	}

	public void delete(Chat chat, SQLiteDatabase db) {
		db.delete(BANG_CHAT, COT_ID + "= ?", 
				new String[] { chat.getId() + "" });
	}
	
	public void save(Chat chat, SQLiteDatabase db) {
		ContentValues values = chatDenDongGiaTri(chat);
		if (exists(chat, db)) {
			db.update(BANG_CHAT, values, COT_ID + "= ?", 
					new String[] { chat.getId() + "" });
		} else {
			values.put(COT_ID, chat.getId());
			db.insert(BANG_CHAT, null, values);
		}
	}
	
	public Chat conTroDenChat(Cursor conTro){
		Chat chat = new Chat();
		chat.setId(conTro.getInt(conTro.getColumnIndex(COT_ID)));
		chat.setTen(conTro.getString(conTro.getColumnIndex(COT_TEN)));
		chat.setTrangThai(conTro.getString(conTro.getColumnIndex(COT_TRANG_THAI)));
		chat.setMau(conTro.getString(conTro.getColumnIndex(COT_MAU)));
		
		return chat;
	}
	
	public ContentValues chatDenDongGiaTri(Chat chat){
		ContentValues dongGiaTri = new ContentValues();
		
		dongGiaTri.put(COT_ID, chat.getId());
		dongGiaTri.put(COT_TEN, chat.getTen());
		dongGiaTri.put(COT_TRANG_THAI, chat.getTrangThai());
		dongGiaTri.put(COT_MAU, chat.getMau());
		
		return dongGiaTri;
	}
}
