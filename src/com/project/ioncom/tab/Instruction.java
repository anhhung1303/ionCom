package com.project.ioncom.tab;

import com.project.ioncom.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Instruction extends Fragment {
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View instruction = inflater.inflate(R.layout.instruction_frag, container, false);
	        ((TextView)instruction.findViewById(R.id.textView)).setText(R.string.content_instruction);
	        return instruction;
	}
}
