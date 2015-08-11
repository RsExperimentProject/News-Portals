package com.example.newsportals;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SportNews extends Activity {

	private ListView sportListView;

	ArrayAdapter<String> adapter;
	private String[] newsTitle;

	private String[] sportNewsTitle;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		setContentView(R.layout.sport_news_activity);

		getActionBar().setDisplayHomeAsUpEnabled(true);

		sportListView = (ListView) findViewById(R.id.sport_listview);

		newsTitle = getResources().getStringArray(R.array.sport_news_title);

		adapter = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.categories_list_patern, R.id.list_patern, newsTitle);
		sportListView.setAdapter(adapter);

		sportNewsTitle = getResources().getStringArray(R.array.sport_news_url);

		sportListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < sportNewsTitle.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(SportNews.this,
								CommonWebViewActivity.class);
						intent.putExtra(Go_url, sportNewsTitle[i]);
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
		getMenuInflater().inflate(R.menu.sport_news, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, StartActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}
}
