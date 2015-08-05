package com.example.newsportals;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class JobsNewsActivity extends Activity {

	private ListView jobsListView;

	ArrayAdapter<String> adapter;
	private String[] newsTitle;

	private String[] jobsLists;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jobs_news_activity);

		jobsListView = (ListView) findViewById(R.id.jobs_listview);

		newsTitle = getResources().getStringArray(R.array.jobs_news_title);

		adapter = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.categories_list_patern, R.id.list_patern, newsTitle);
		jobsListView.setAdapter(adapter);

		jobsLists = getResources().getStringArray(R.array.jobs_news_url);

		jobsListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < jobsLists.length && i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(JobsNewsActivity.this,
								CommonWebViewActivity.class);
						intent.putExtra(Go_url, jobsLists[i]);
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
		getMenuInflater().inflate(R.menu.jobs_news, menu);
		return true;
	}

}
