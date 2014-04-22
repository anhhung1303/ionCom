package com.project.ioncom.tab;

import com.project.ioncom.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class List extends Fragment {
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View list = inflater.inflate(R.layout.list_frag, container, false);
	        ((TextView)list.findViewById(R.id.textView)).setText(R.string.content_list);
	        return list;
	}
}
