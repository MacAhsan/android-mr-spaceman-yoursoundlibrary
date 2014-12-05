package com.labs.adapters;

import java.security.acl.LastOwnerException;
import java.util.ArrayList;

import com.labs.mrspaceman.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class SongGridAdapter extends BaseAdapter {
	ArrayList<String> items;
	Context context;
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}
	
	public void setData(ArrayList<String> items, Context context){
		this.items = items;
		this.context = context;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.grid_sound, null);
		}
		String item = items.get(position);
		TextView sound_name = (TextView)convertView.findViewById(R.id.sound_name);
		item = item.substring(0, item.lastIndexOf("."));
		sound_name.setText(item);
		
		return convertView;
	}

}
