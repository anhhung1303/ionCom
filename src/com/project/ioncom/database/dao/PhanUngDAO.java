package com.project.ioncom.database.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.project.ioncom.model.PhanUng;

public class PhanUngDAO {
		final public static String BANG_CHAT = "phan_ung";
		
		public static final String COT_ID = "id";
		public static final String COT_CHAT_VAO = "chat_vao";
		public static final String COT_CHAT_RA = "chat_ra";
		public static final String COT_DIEU_KIEN = "dieu_kien";
		
		public boolean exists(PhanUng phanUng, SQLiteDatabase db) {
			Cursor conTro = db.query(BANG_CHAT, new String[] {COT_ID}, COT_ID + "= ?", 
					new String[] { phanUng.getId() + "" }, null, null, null);
			boolean result = conTro.moveToFirst();
			conTro.close();
			return result;
		}
		
		public void reload(PhanUng phanUng, SQLiteDatabase db) {
			Cursor conTro = db.query(BANG_CHAT, new String[] {"*"}, COT_ID + "= ?", 
					new String[] { phanUng.getId() + "" }, null, null, null);
			if (conTro.moveToFirst()) {
				phanUng = conTroDenPhanUng(conTro);
			}
			conTro.close();
		}

		public void delete(PhanUng phanUng, SQLiteDatabase db) {
			db.delete(BANG_CHAT, COT_ID + "= ?", 
					new String[] { phanUng.getId() + "" });
		}
		
		public void save(PhanUng phanUng, SQLiteDatabase db) {
			ContentValues values = phanUngDenDongGiaTri(phanUng);
			if (exists(phanUng, db)) {
				db.update(BANG_CHAT, values, COT_ID + "= ?", 
						new String[] { phanUng.getId() + "" });
			} else {
				values.put(COT_ID, phanUng.getId());
				db.insert(BANG_CHAT, null, values);
			}
		}
		
		public PhanUng conTroDenPhanUng(Cursor conTro){
			PhanUng phanUng = new PhanUng();
			
			phanUng.setId(conTro.getInt(conTro.getColumnIndex(COT_ID)));
			phanUng.setChatVao(conTro.getString(conTro.getColumnIndex(COT_CHAT_VAO)));
			phanUng.setChatRa(conTro.getString(conTro.getColumnIndex(COT_CHAT_RA)));
			phanUng.setDieuKien(conTro.getString(conTro.getColumnIndex(COT_DIEU_KIEN)));
			
			return phanUng;
		}
		
		public ContentValues phanUngDenDongGiaTri(PhanUng phanUng){
			ContentValues dongGiaTri = new ContentValues();
			
			dongGiaTri.put(COT_ID, phanUng.getId());
			dongGiaTri.put(COT_CHAT_VAO, phanUng.getChatVao());
			dongGiaTri.put(COT_CHAT_RA, phanUng.getChatRa());
			dongGiaTri.put(COT_DIEU_KIEN, phanUng.getDieuKien());
			
			return dongGiaTri;
		}
	}
