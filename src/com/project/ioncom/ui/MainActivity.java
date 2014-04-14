package com.project.ioncom.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;

import com.project.ioncom.R;

public class MainActivity extends Activity {
	// private Font mFont;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Handle new Experiment
		TextView newText = (TextView) findViewById(R.id.newText);
		newText.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				setContentView(R.layout.layout_on_experiment);
				return false;
			}
		});
		
		// Handle list Experiment
		TextView listText = (TextView) findViewById(R.id.listText);
		listText.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				setContentView(R.layout.layout_on_list);
				return false;
			}
		});
		
		// Handle about
		TextView aboutText = (TextView) findViewById(R.id.aboutText);
		aboutText.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				setContentView(R.layout.layout_on_about);
				return false;
			}
		});
		
		// Handle exit Experiment
		TextView exitText = (TextView) findViewById(R.id.exitText);
		exitText.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				finish();
				System.exit(1);
				return false;
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
