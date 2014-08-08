package com.example.typeform.ui.util;

import java.util.ArrayList;

import com.example.typeform.R;
import com.example.typeform.ui.model.AnswerModel;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class ListRadioTxtAdapter extends ArrayAdapter<AnswerModel> {

	private ArrayList<AnswerModel> answerList;
	Context context;

	public ListRadioTxtAdapter(Context context, int textViewResourceId, 
			ArrayList<AnswerModel> answerList) {
		super(context, textViewResourceId, answerList);
		this.answerList = new ArrayList<AnswerModel>();
		this.answerList.addAll(answerList);
		this.context = context;
	}

	private class ViewHolder {
		TextView contenTxt;
		TextView valueTxt;
		EditText contentEditTxt;
		TextView numberTxt;
		RadioButton select;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		AnswerModel answer = answerList.get(position);
		Log.v("ConvertView", String.valueOf(position));
		LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {


			if(answer.getType().equalsIgnoreCase("radio")){
				convertView = vi.inflate(R.layout.listrow_radio, null);
				holder = new ViewHolder();
				holder.contenTxt = (TextView) convertView.findViewById(R.id.textContent);
				holder.contenTxt.setText(answer.getContent());
			}else{
				convertView = vi.inflate(R.layout.listrow_radiotxt, null);
				holder = new ViewHolder();
				holder.contentEditTxt = (EditText) convertView.findViewById(R.id.textContent);
				holder.contentEditTxt.setText("");
				holder.contentEditTxt.setTag(answer);
				holder.contentEditTxt.setHint(answer.getContent());
				/*holder.contentEditTxt.setOnTouchListener(new View.OnTouchListener() {

					@Override
					public boolean onTouch(View v, MotionEvent event) {
						// TODO Auto-generated method stub
						EditText rb = (EditText) v ;  
						AnswerModel answer = (AnswerModel) rb.getTag();  
						answer.setSelected(true);
						answer.setValue("Hasil : "+answer.getId());

						for (AnswerModel sa : answerList) {
							if(!sa.equals(answer)){
								sa.setSelected(false);
								sa.setValue("Hasil : - ");
							}
						}
						notifyDataSetChanged();
						return true;
					}
				});*/
			}

			//holder.contenTxt = (TextView) convertView.findViewById(R.id.textContent);
			holder.numberTxt = (TextView) convertView.findViewById(R.id.textNumber);
			holder.valueTxt = (TextView) convertView.findViewById(R.id.textValue);
			holder.select = (RadioButton) convertView.findViewById(R.id.radioButton1);


			convertView.setTag(holder);

			holder.select.setOnClickListener( new View.OnClickListener() {  

				public void onClick(View v) {  
					RadioButton rb = (RadioButton) v ;  
					AnswerModel answer = (AnswerModel) rb.getTag();  
					answer.setSelected(rb.isChecked());
					answer.setValue("Hasil : "+answer.getId());
					if (rb.isChecked()) //OFF->ON
					{
						for (AnswerModel sa : answerList) {
							if(!sa.equals(answer)){
								sa.setSelected(false);
								sa.setValue("Hasil : - ");
							}
						}
						notifyDataSetChanged();
					} 

				}  
			});  
		} 
		else {
			holder = (ViewHolder) convertView.getTag();
		}


		//holder.code.setText(" (" +  answer.getCode() + ")");

		holder.valueTxt.setText(answer.getValue());
		holder.numberTxt.setText(answer.getId());
		holder.select.setChecked(answer.isSelected());
		holder.select.setTag(answer);

		//holder.contenTxt.setTag(answer);

		return convertView;

	}

}
