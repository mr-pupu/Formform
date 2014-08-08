package com.example.typeform.ui;



import com.example.typeform.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActionBar().setTitle("MainActivity");
        Button btnSingleChoice = (Button) findViewById(R.id.button_singlechoice);
        btnSingleChoice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), TypeActivity.class);
				i.putExtra("TypeList", "singleChoice");
				startActivity(i);
			}
		});
        
        Button btnSingleChoiceTxt = (Button) findViewById(R.id.button_singlechoice_txt);
        btnSingleChoiceTxt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), TypeActivity.class);
				i.putExtra("TypeList", "singleChoiceTxt");
				startActivity(i);
			}
		});
        
        Button btnMultipleChoice = (Button) findViewById(R.id.button_multichoice);
        btnMultipleChoice.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), TypeActivity.class);
				i.putExtra("TypeList", "multipleChoise");
				startActivity(i);
			}
		});
        
        Button btnMultipleChoiceTxt = (Button) findViewById(R.id.button_multichoice_txt);
        btnMultipleChoiceTxt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(), TypeActivity.class);
				i.putExtra("TypeList", "multipleChoiseTxt");
				startActivity(i);
			}
		});
        
        
       
    }
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
   
}
