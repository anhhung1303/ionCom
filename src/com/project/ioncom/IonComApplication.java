package com.project.ioncom;

import android.app.Application;
import android.util.Log;

import com.project.ioncom.database.DatabaseManager;

public class IonComApplication extends Application{
	private String TAG = "IonComApplication";
	@Override
	public void onCreate() {
		super.onCreate();
		//Load database
		if (DatabaseManager.getInstance(getApplicationContext()) != null){
			Log.d(TAG, "Load database from assets successfully!!!");
			
		}
	}
}
