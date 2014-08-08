package com.example.typeform.ui;

import java.util.ArrayList;

import com.example.typeform.R;
import com.example.typeform.ui.model.AnswerModel;
import com.example.typeform.ui.util.ListRadioAdapter;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RadioFragment extends Fragment{

	private View rootView;
	private ListRadioAdapter adapter;

	public RadioFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_singlechoice, container,false);
		
		ArrayList<AnswerModel> answerList = new ArrayList<AnswerModel>();
		AnswerModel answer = 
				new AnswerModel("1","A","answer1","1","radio",false);
		answerList.add(answer);
		answer = new AnswerModel("2","B","answer2","2","radio",false);
		answerList.add(answer);
		answer = new AnswerModel("3","C","answer3","3","radio",false);
		answerList.add(answer);
		answer = new AnswerModel("4","D","answer4","4","radio",false);
		answerList.add(answer);
		answer = new AnswerModel("5","E","answer5","5","radio",false);
		answerList.add(answer);
		
		
		
		ListView lv = (ListView) rootView.findViewById(R.id.listViewAnswer);
		adapter = new ListRadioAdapter(getActivity().getApplicationContext(),R.layout.listrow_radio,answerList);
		adapter.notifyDataSetChanged();
		
		lv.setAdapter(adapter);
		
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
	}

	
}