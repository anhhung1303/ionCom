package com.project.ioncom.tab;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.project.ioncom.R;
import com.project.ioncom.adapter.ExperimentAdapter;
import com.project.ioncom.database.dao.ExperimentDAO;
import com.project.ioncom.model.Experiment;

public class ShowExperimentNameFragment extends Fragment {
	final private String TAG = ShowExperimentNameFragment.class.getSimpleName();
	private ListView mListView;
	private List<Experiment> mList;
	private ExperimentAdapter mAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View fragmentView = inflater.inflate(
				R.layout.show_experiment_name_frag, container, false);

		mListView = (ListView) fragmentView
				.findViewById(R.id.lv_experiment_names);
		ExperimentDAO dao = new ExperimentDAO();
		mList = dao.queryAll();
		for (Experiment experiment : mList) {
			Log.d(TAG, "experiment = " + experiment.getId());
		}
		mAdapter = new ExperimentAdapter(this.getActivity(),
				R.layout.list_row_experiment, mList);
		mListView.setAdapter(mAdapter);

		mListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long itemId) {
				Experiment experiment = mAdapter.getItem(position);
				ExperimentActivity.call(
						ShowExperimentNameFragment.this.getActivity(),
						experiment.getId());
			}
		});

		return fragmentView;
	}
}
