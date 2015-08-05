package com.ramananda.bean;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.newsportals.R;

public class BanglaAdapter extends BaseAdapter {

	public static final String FONT = "SolaimanLipi.ttf";

	private Context context;
	private ArrayList<Category> newsItems = new ArrayList<Category>();

	public BanglaAdapter(Context context, ArrayList<Category> newsItems) {
		this.context = context;
		this.newsItems = newsItems;
	}

	@Override
	public int getCount() {
		return newsItems.size();
	}

	@Override
	public Object getItem(int position) {
		return newsItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.categories_list_patern,
					null);
		}
		TextView txtTitle = (TextView) convertView
				.findViewById(R.id.list_patern);
		txtTitle.setText(newsItems.get(position).getTitle());
		txtTitle.setTypeface(Typeface.createFromAsset(context.getAssets(),
				BanglaAdapter.FONT));
		txtTitle.setTextSize(21);
		return convertView;
	}
}
