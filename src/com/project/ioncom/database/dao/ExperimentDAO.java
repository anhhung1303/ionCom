package com.project.ioncom.database.dao;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.project.ioncom.database.DatabaseManager;
import com.project.ioncom.model.Experiment;

public class ExperimentDAO {
		final private String TAG = ExperimentDAO.class.getSimpleName();
		final public static String TABLE_NAME = "phan_ung";
		
		final public static String COL_ID = "id";
		final public static String COL_NAME = "ten";
		final public static String COL_TOOL = "dung_cu_tn";
		final public static String COL_STEP = "cac_buoc_tien_hanh";
		final public static String COL_PHENOMENA = "hien_tuong";
		final public static String COL_EQUATION = "phuong_trinh";
		final public static String COL_EXPLANATION = "giai_thich_hien_tuong";
		final public static String COL_FILE_NAME = "gif";
		
		public Experiment queryWithID(int id){
			SQLiteDatabase db = DatabaseManager.getInstance(null).getReadableDatabase();
			
			Cursor cursor = db.query(TABLE_NAME, new String[] {"*"}, COL_ID + "= ?", 
					new String[] { id + "" }, null, null, null);
			boolean result = cursor.moveToFirst();
			if (result){
				return convertCursorToExperiment(cursor);
			} else {
				return null;
			}
		}
		
		public List<Experiment> queryAll(){
			SQLiteDatabase db = DatabaseManager.getInstance(null).getReadableDatabase();
			List<Experiment> list = new ArrayList<Experiment>();
			
			Cursor cursor = db.query(TABLE_NAME, new String[] {"*"}, "1 = 1", 
					null, null, null, null);
			boolean result = cursor.moveToFirst();
			Log.e(TAG, "result = " + result);
			while (result){
				list.add(convertCursorToExperiment(cursor));				
				result = cursor.moveToNext();
			}
			cursor.close();
			
			return list;
		}
		
		private Experiment convertCursorToExperiment(Cursor cursor){
			Experiment experiment = new Experiment();
			
			experiment.setId(cursor.getInt(cursor.getColumnIndex(COL_ID)));
			experiment.setName(cursor.getString(cursor.getColumnIndex(COL_NAME)));
			experiment.setTools(cursor.getString(cursor.getColumnIndex(COL_TOOL)));
			experiment.setSteps(cursor.getString(cursor.getColumnIndex(COL_STEP)));
			experiment.setPhenomen(cursor.getString(cursor.getColumnIndex(COL_PHENOMENA)));
			experiment.setReactionEquation(cursor.getString(cursor.getColumnIndex(COL_EQUATION)));
			experiment.setExplanation(cursor.getString(cursor.getColumnIndex(COL_EXPLANATION)));
			experiment.setFileName(cursor.getString(cursor.getColumnIndex(COL_FILE_NAME)));
			
			return experiment;
		}

	}
