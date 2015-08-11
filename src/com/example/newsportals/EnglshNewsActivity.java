package com.example.newsportals;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class EnglshNewsActivity extends Activity {

	private ListView englishNewsList;

	ArrayAdapter<String> adapter;
	private String[] newsTitle;

	private String[] englishNewsUrl;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.englsh_news_activity);

		englishNewsList = (ListView) findViewById(R.id.English_listview);

		newsTitle = getResources().getStringArray(R.array.english_news_title);

		adapter = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.categories_list_patern, R.id.list_patern, newsTitle);
		englishNewsList.setAdapter(adapter);

		englishNewsUrl = getResources()
				.getStringArray(R.array.english_news_url);

		englishNewsList.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < englishNewsUrl.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(EnglshNewsActivity.this,
								CommonWebViewActivity.class);
						intent.putExtra(Go_url, englishNewsUrl[i]);
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
		getMenuInflater().inflate(R.menu.englsh_news, menu);
		return true;
	}

}
