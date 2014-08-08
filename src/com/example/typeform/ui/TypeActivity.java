package com.example.typeform.ui;

import com.example.typeform.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class TypeActivity extends FragmentActivity{

	private Fragment fragment;
	private String typeList;
	private final String SINGLECHOICE = "singleChoice";
	private final String SINGLECHOICE_TXT = "singleChoiceTxt";
	private final String MULTIPLECHOICE = "multipleChoise";
	private final String MULTIPLECHOICE_TXT = "multipleChoiseTxt";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_type);
		getActionBar().setTitle("TypeActivity");
		/*getWindow()
			.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);*/
		
		//TODO switch fragment
		typeList = getIntent().getStringExtra("TypeList");
		if (savedInstanceState == null) {
			if(typeList.equals(SINGLECHOICE)){
				
				fragment = new RadioFragment(); 
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager
					.beginTransaction()
						.replace(R.id.frame_container_fragment, fragment).commit();
				getActionBar().setTitle("TypeActivity:RadioFragment");
				
			}else if(typeList.equals(SINGLECHOICE_TXT)){
				
				fragment = new RadioTxtFragment(); 
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager
					.beginTransaction()
						.replace(R.id.frame_container_fragment, fragment).commit();
				getActionBar().setTitle("TypeActivity:RadioTxtFragment");
				
			}else if(typeList.equals(MULTIPLECHOICE)){
				
				fragment = new CheckboxFragment(); 
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager
					.beginTransaction()
						.replace(R.id.frame_container_fragment, fragment).commit();
				getActionBar().setTitle("TypeActivity:CheckboxFragment");
				
			}else if(typeList.equals(MULTIPLECHOICE_TXT)){
				fragment = new RadioFragment(); 
				FragmentManager fragmentManager = getSupportFragmentManager();
				fragmentManager
					.beginTransaction()
						.replace(R.id.frame_container_fragment, fragment).commit();
			}
		}

	}

}
