package com.project.ioncom.ui;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.project.ioncom.R;

public class MainActivity extends FragmentActivity {
	// private Font mFont;
	ArrayList<String> arrActions = new ArrayList<String>();
	ListView lvActions;
	ArrayAdapter<String> adapterAction;
	DrawerLayout frameLayout;

	// private ArrayList<ListFragment> arrFragments;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initData();
		lvActions.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				switch(arg2){
				case 3:
					doAbout();
					break;
				}
			}
		
		});
	}

	private void initData() {
		// TODO Auto-generated method stub
		arrActions.add("New");
		arrActions.add("List");
		arrActions.add("Instruction");
		arrActions.add("About");
		arrActions.add("Quit");
		lvActions = (ListView) findViewById(R.id.lvActions);
		adapterAction = new ArrayAdapter<String>(getApplicationContext(),
				android.R.layout.simple_list_item_1, arrActions);
		lvActions.setAdapter(adapterAction);
		// frameLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
	}
	private void doAbout() {
		
		// TODO Auto-generated method stub
		ListFragment fragment = new ListFragment();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction().replace(R.id.loContent,
				fragment).commit();
		//frameLayout.closeDrawer(null);

	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
