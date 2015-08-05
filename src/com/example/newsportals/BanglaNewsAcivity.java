package com.example.newsportals;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.ramananda.bean.BanglaAdapter;
import com.ramananda.bean.Category;

public class BanglaNewsAcivity extends Activity {

	private ListView banglaListView;

	BanglaAdapter adapter;
	private String[] newsTitle;

	ArrayList<Category> newsList;

	private String[] banglaNewsUrl;
	String Go_url = "url_link";
	String Title = "news_title";
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bangla_news_acivity);
		
		
		banglaListView = (ListView) findViewById(R.id.bangla_listview);

		newsTitle = getResources().getStringArray(R.array.bangla_news_title);
		newsList = new ArrayList<Category>();
		for (int i = 0; i < newsTitle.length; i++) {
			Category title = new Category(newsTitle[i]);
			newsList.add(title);
		}

		adapter = new BanglaAdapter(getApplicationContext(), newsList);
		banglaListView.setAdapter(adapter);

		banglaNewsUrl = getResources().getStringArray(R.array.bangla_news_url);

		banglaListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < banglaNewsUrl.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(BanglaNewsAcivity.this,
								BanglaWebView.class);
						intent.putExtra(Go_url, banglaNewsUrl[i]);
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
		getMenuInflater().inflate(R.menu.bangla_news_acivity, menu);
		return true;
	}

}
