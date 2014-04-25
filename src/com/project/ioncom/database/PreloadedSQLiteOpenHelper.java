package com.project.ioncom.database;

/**
 * This file content belongs to RikkeiSoft.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class PreloadedSQLiteOpenHelper extends SQLiteOpenHelper {
	private Context context;
	public PreloadedSQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.context = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// No need to do anything
	}
	
	/**
	 * Check if the database already exist
	 *  
	 * @return
	 */
	private boolean checkDataBase() {
        File dbFile = new File(getDatabasePath() + getDatabaseName());
        return dbFile.exists();
    }
	
	/**
	 * Preparing the database, should be put into an ASyncTask
	 */
	public void prepare() {
		if (checkDataBase()) return;
		// Create the file
		getReadableDatabase();
		close();
		
		// And then copy it
		try {
			copyDataBase();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Copy the database file from assets to its location
	 * 
	 * @throws IOException
	 */
	private void copyDataBase() throws IOException {
        InputStream mInput = context.getAssets().open(getDatabaseName());
        String outFileName = getDatabasePath() + getDatabaseName();
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO consider if this should be implemented 
	}

	@SuppressLint("SdCardPath")
	public String getDatabasePath() {
		if(android.os.Build.VERSION.SDK_INT >= 17) {
	       return context.getApplicationInfo().dataDir + "/databases/";         
	    } else {
	       return "/data/data/" + context.getPackageName() + "/databases/";
	    }
	}
	
	public abstract String getDatabaseName();
}