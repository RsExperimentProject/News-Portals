package com.example.newsportals;

import java.util.ArrayList;

import com.ramananda.bean.BanglaAdapter;
import com.ramananda.bean.Category;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TechnologyNews extends Activity {
	
	private ListView technologyLists;

	BanglaAdapter adapter;
	private String[] newsTitle;

	ArrayList<Category> newsList;

	private String[] technologyUrl;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.technology_news_activity);

		technologyLists = (ListView) findViewById(R.id.technology_listview);

		newsTitle = getResources()
				.getStringArray(R.array.technology_news_title);
		newsList = new ArrayList<Category>();
		for (int i = 0; i < newsTitle.length; i++) {
			Category title = new Category(newsTitle[i]);
			newsList.add(title);
		}

		adapter = new BanglaAdapter(getApplicationContext(), newsList);
		technologyLists.setAdapter(adapter);

		technologyUrl = getResources().getStringArray(
				R.array.technology_news_url);

		technologyLists.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < technologyUrl.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(TechnologyNews.this,
								BanglaWebView.class);
						intent.putExtra(Go_url, technologyUrl[i]);
						intent.putExtra(Title, newsTitle[i]);
						startActivity(intent);
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.technology_news, menu);
		return true;
	}

}
