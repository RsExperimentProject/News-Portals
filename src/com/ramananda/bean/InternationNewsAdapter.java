package com.ramananda.bean;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.newsportals.R;

public class InternationNewsAdapter extends BaseAdapter implements Filterable {

	Context context;
	ArrayList<Category> newsTitles;
	ArrayList<Category> searchTitles;

	WordFilter valueFilter;

	public InternationNewsAdapter(Context context, ArrayList<Category> titles) {
		this.context = context;
		this.newsTitles = titles;
		this.searchTitles = titles;
	}

	@Override
	public int getCount() {
		return newsTitles.size();
	}

	@Override
	public Object getItem(int position) {
		return newsTitles.get(position);
	}

	public class ViewHolder {
		TextView Title, State;
	}

	@Override
	public long getItemId(int position) {
		return newsTitles.indexOf(getItem(position));
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ViewHolder holder;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = inflater.inflate(R.layout.internation_list_adapter,
					null);
			holder.Title = (TextView) convertView
					.findViewById(R.id.internation_news_title);
			holder.State = (TextView) convertView
					.findViewById(R.id.internation_news_state);
			// String str = ((TextView) convertView.findViewById(R.id.txt_eng))
			// .getText().toString();

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.Title.setText(newsTitles.get(position).getTitle());
		holder.State.setText(newsTitles.get(position).getState());

		return convertView;
	}

	@Override
	public Filter getFilter() {
		if (valueFilter == null) {
			valueFilter = new WordFilter();
		}
		return valueFilter;
	}

	private class WordFilter extends Filter {

		@Override
		protected FilterResults performFiltering(CharSequence constraint) {
			FilterResults results = new FilterResults();
			if (constraint != null && constraint.length() > 0) {
				ArrayList<Category> filterList = new ArrayList<Category>();
				for (int i = 0; i < searchTitles.size(); i++) {
					if ((searchTitles.get(i).getTitle().toLowerCase())
							.contains(constraint.toString().toLowerCase())) {
						Category words = new Category(searchTitles.get(i)
								.getTitle(), searchTitles.get(i).getState());
						filterList.add(words);
					}
				}
				results.count = filterList.size();
				results.values = filterList;
			} else {
				results.count = searchTitles.size();
				results.values = searchTitles;
			}
			return results;
		}

		@Override
		protected void publishResults(CharSequence constraint,
				FilterResults results) {
			newsTitles = (ArrayList<Category>) results.values;
			notifyDataSetChanged();
		}

	}

}
