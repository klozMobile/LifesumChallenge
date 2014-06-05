package com.example.lifesum.adapters;

import java.util.List;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.lifesum.R;
import com.example.lifesum.model.Food;

public class FoodListAdapter extends ArrayAdapter<Food> {

	public FoodListAdapter(Context context, int resource) {
		super(context, resource, R.id.tv_title);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = super.getView(position, convertView, parent);
			holder = new ViewHolder();
			holder.title = (TextView) convertView.findViewById(R.id.tv_title);
			holder.pcstext =(TextView) convertView.findViewById(R.id.tv_description);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Food item = getItem(position);
		holder.title.setText(item.getTitle());
		holder.pcstext.setText(item.getPcstext().length()>1?item.getPcstext():" ");
		return convertView;
	}

	public void supporAddAll(List<Food> list) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.GINGERBREAD_MR1) {
			addAllHoneycomb(list);
		} else {
			for (Food food : list) {
				add(food);
			}
		}
		notifyDataSetChanged();
	}
	
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	public void addAllHoneycomb(List<Food> list) {
		addAll(list);
	}

	class ViewHolder {
		public TextView title;
		public TextView pcstext;
	}
}
