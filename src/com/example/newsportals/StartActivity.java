package com.example.newsportals;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StartActivity extends Activity {

	ListView lv;

	ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);

		lv = (ListView) findViewById(R.id.newsCategories);

		adapter = new ArrayAdapter<String>(this,
				R.layout.categories_list_patern, R.id.list_patern,
				getResources().getStringArray(R.array.news_category_items));
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				switch (position) {
				case 0:
					Intent bangla_Intent = new Intent(StartActivity.this,
							BanglaNewsAcivity.class);
					startActivity(bangla_Intent);

					break;
				case 1:
					Intent i = new Intent(StartActivity.this,
							EnglshNewsActivity.class);
					startActivity(i);
					break;
				case 2:
					Intent m = new Intent(StartActivity.this,
							MagazineNews.class);
					startActivity(m);
					break;
				case 3:
					Intent jobsIntent = new Intent(StartActivity.this,
							JobsNewsActivity.class);
					startActivity(jobsIntent);
					break;

				case 4:
					Intent technologyIntent = new Intent(StartActivity.this,
							TechnologyNews.class);
					startActivity(technologyIntent);
					break;
				case 5:
					Intent sportIntent = new Intent(StartActivity.this,
							SportNews.class);
					startActivity(sportIntent);
					break;
				case 6:
					Intent businessIntent = new Intent(StartActivity.this,
							BusinessNews.class);
					startActivity(businessIntent);
					break;
				default:
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.start, menu);

		return super.onCreateOptionsMenu(menu);
	}

}
