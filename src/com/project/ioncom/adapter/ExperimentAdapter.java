package com.project.ioncom.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.project.ioncom.R;
import com.project.ioncom.model.Experiment;

public class ExperimentAdapter extends ArrayAdapter<Experiment>{
	//private String TAG = ExperimentAdapter.class.getSimpleName();
	
	private LayoutInflater inflater = null;
	private int layoutID = 0;

	public ExperimentAdapter(Context context, int resource,
			List<Experiment> objects) {
		super(context, resource, objects);
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.layoutID = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		View view = convertView;
		if (convertView == null){
			view = this.inflater.inflate(this.layoutID, null);
			holder = new ViewHolder();
			
			holder.tvExperimentName = (TextView) view.findViewById(R.id.tv_name);
			
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		Experiment thisExperiment = getItem(position);
		holder.tvExperimentName.setText(thisExperiment.getName());
		
		return view;
	}

	private class ViewHolder {
		TextView tvExperimentName;
	}
}
