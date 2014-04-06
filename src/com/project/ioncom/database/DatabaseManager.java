package com.project.ioncom.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.project.ioncom.config.Define;


//Note: database will be created outside and push to program
public class DatabaseManager extends SQLiteOpenHelper {
	
	public DatabaseManager(Context context) {
		super(context, Define.DATABASE_NAME, null, Define.DATABASE_VERSION);
	}

	@Override
	public String getDatabaseName() {
		return Define.DATABASE_NAME;
	}
	
	public void init() {
		getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//intentionally do nothing
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		//intentionally do nothing
	}
}