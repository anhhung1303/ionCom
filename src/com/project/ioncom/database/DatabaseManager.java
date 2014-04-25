package com.project.ioncom.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.ioncom.config.Define;


//Note: database will be created outside and push to program
public class DatabaseManager extends PreloadedSQLiteOpenHelper {
	private static String TAG = DatabaseManager.class.getSimpleName();
	
	private static DatabaseManager onlyInstance = null;
	
	
	private DatabaseManager(Context context) {
		super(context, Define.DATABASE_NAME, null, Define.DATABASE_VERSION);
	}
	
	public static DatabaseManager getInstance(Context context){
		if (onlyInstance == null){
			if (context != null){
				onlyInstance = new DatabaseManager(context); 
				onlyInstance.prepare();
			} else {
				Log.e(TAG, "create new DatabaseManager with null context");
			}
		}
		return onlyInstance;
	}

	@Override
	public String getDatabaseName() {
		return Define.DATABASE_NAME;
	}
	
	public void init() {
//		getWritableDatabase();
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