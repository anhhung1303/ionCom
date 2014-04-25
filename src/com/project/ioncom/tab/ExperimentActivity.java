package com.project.ioncom.tab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.project.ioncom.R;
import com.project.ioncom.config.Define;
import com.project.ioncom.database.dao.ExperimentDAO;
import com.project.ioncom.model.Experiment;

public class ExperimentActivity extends Activity {
	final private String TAG = ExperimentActivity.class.getSimpleName();

	private String curURL = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_experiment);

		int experimentId = getIntent().getIntExtra(Define.BUNDLE_EXPERIMENT_ID,
				100);
		ExperimentDAO dao = new ExperimentDAO();
		Experiment experiment = dao.queryWithID(experimentId);
		Log.d(TAG, "experiment: " + experiment.toString());
		curURL = "file:///android_asset/experimentImages/"
				+ experiment.getFileName() + ".gif";

		WebView webView = (WebView) findViewById(R.id.webView);
		Log.d("TAG", "Start loading file: " + curURL);
		webView.loadUrl(curURL);
	}

	public void showInfoOnClicked(View view) {
		Button showInfoButton = (Button) findViewById(R.id.btn_show_info);
		showInfoButton.setVisibility(View.GONE);
		LinearLayout showInfoLayout = (LinearLayout) findViewById(R.id.ll_show_info);
		showInfoLayout.setVisibility(View.VISIBLE);
	}
	
	public void hideInfoOnClicked(View view){
		LinearLayout showInfoLayout = (LinearLayout) findViewById(R.id.ll_show_info);
		showInfoLayout.setVisibility(View.GONE);
		Button showInfoButton = (Button) findViewById(R.id.btn_show_info);
		showInfoButton.setVisibility(View.VISIBLE);
	}

	static public void call(Activity activity, int ExperimentId) {
		Intent intent = new Intent(activity, ExperimentActivity.class);
		intent.putExtra(Define.BUNDLE_EXPERIMENT_ID, ExperimentId);
		activity.startActivity(intent);
	}
}
