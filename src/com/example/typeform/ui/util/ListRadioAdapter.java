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
import android.widget.RadioButton;
import android.widget.TextView;


public class ListRadioAdapter extends ArrayAdapter<AnswerModel> {

	private ArrayList<AnswerModel> answerList;
	Context context;

	public ListRadioAdapter(Context context, int textViewResourceId, 
			ArrayList<AnswerModel> answerList) {
		super(context, textViewResourceId, answerList);
		this.answerList = new ArrayList<AnswerModel>();
		this.answerList.addAll(answerList);
		this.context = context;
	}

	private class ViewHolder {
		TextView contenTxt;
		TextView valueTxt;
		TextView numberTxt;
		RadioButton select;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		ViewHolder holder = null;
		Log.v("ConvertView", String.valueOf(position));

		if (convertView == null) {
			LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = vi.inflate(R.layout.listrow_radio, null);


			holder = new ViewHolder();
			holder.contenTxt = (TextView) convertView.findViewById(R.id.textContent);
			holder.valueTxt = (TextView) convertView.findViewById(R.id.textValue);
			holder.numberTxt = (TextView) convertView.findViewById(R.id.textNumber);
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

		AnswerModel answer = answerList.get(position);
		//holder.code.setText(" (" +  answer.getCode() + ")");
		holder.contenTxt.setText(answer.getContent());
		holder.valueTxt.setText(answer.getValue());
		holder.numberTxt.setText(answer.getId());
		holder.select.setChecked(answer.isSelected());
		holder.select.setTag(answer);

		//holder.contenTxt.setTag(answer);

		return convertView;

	}

}
