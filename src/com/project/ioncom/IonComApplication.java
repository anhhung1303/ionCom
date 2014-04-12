package com.project.ioncom;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.project.ioncom.database.DatabaseManager;

public class IonComApplication extends Application{
	private DatabaseManager mDBManager = null;

	private DatabaseManager getDatabaseManager(){
		if (mDBManager == null){
			mDBManager = new DatabaseManager(getApplicationContext());
		}
		return mDBManager;
	}
	
	public SQLiteDatabase getReadableDatabase(){
		return getDatabaseManager().getReadableDatabase();
	}
	
	public SQLiteDatabase getWritableDatabase(){
		return getDatabaseManager().getWritableDatabase();
	}
}
