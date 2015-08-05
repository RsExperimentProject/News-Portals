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

public class BusinessNews extends Activity {

	private ListView businessListView;

	ArrayAdapter<String> adapter;
	private String[] newsTitle;

	private String[] businessNewsTitle;
	String Go_url = "url_link";
	String Title = "news_title";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.business_news_activity);

		businessListView = (ListView) findViewById(R.id.business_listview);

		newsTitle = getResources().getStringArray(R.array.business_news_title);

		adapter = new ArrayAdapter<String>(getApplicationContext(),
				R.layout.categories_list_patern, R.id.list_patern, newsTitle);
		businessListView.setAdapter(adapter);

		businessNewsTitle = getResources().getStringArray(R.array.business_news_url);

		businessListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				for (int i = 0; i < businessNewsTitle.length
						&& i < newsTitle.length; i++) {
					if (position == i) {
						Intent intent = new Intent(BusinessNews.this,
								CommonWebViewActivity.class);
						intent.putExtra(Go_url, businessNewsTitle[i]);
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
		getMenuInflater().inflate(R.menu.business_news, menu);
		return true;
	}

}
