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

public class MagazineNews extends Activity {

	private ListView magazineListView;

	BanglaAdapter adapter;
	private String[] newsTitle;

	ArrayList<Category> newsList;

	private String[] magazineListUrl;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.magazine_news_activity);

		magazineListView = (ListView) findViewById(R.id.magazine_listview);

		newsTitle = getResources().getStringArray(R.array.magazine_news_title);
		newsList = new ArrayList<Category>();
		for (int i = 0; i < newsTitle.length; i++) {
			Category title = new Category(newsTitle[i]);
			newsList.add(title);
		}

		adapter = new BanglaAdapter(getApplicationContext(), newsList);
		magazineListView.setAdapter(adapter);

		magazineListUrl = getResources().getStringArray(
				R.array.magazine_news_url);

		magazineListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < magazineListUrl.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(MagazineNews.this,
								BanglaWebView.class);
						intent.putExtra(Go_url, magazineListUrl[i]);
						intent.putExtra(Title, newsTitle[i]);
						startActivity(intent);
					}
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.magazine_news, menu);
		return true;
	}

}
