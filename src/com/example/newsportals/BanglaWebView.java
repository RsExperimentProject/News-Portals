package com.example.newsportals;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.ramananda.bean.ConnectDetect;

public class BanglaWebView extends Activity {

	private WebView mWebView;
	// fetch url and title
	String Go_url = "url_link";
	String Title = "news_title";
	public static final String FONT = "SolaimanLipi.ttf";
	String getUrl;
	String getTitle;

	String TAG = "this is website";
	ProgressBar mProgressBar;
	ConnectDetect connectDetect;
	boolean connection = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		// getWindow().requestFeature(Window.FEATURE_PROGRESS);
		setContentView(R.layout.web_view_acivity);

		connectDetect = new ConnectDetect(getApplicationContext());
		Log.i(TAG, "Create");
		mWebView = (WebView) findViewById(R.id.webView);
		mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
		getUrl = getIntent().getStringExtra(Go_url);
		getTitle = getIntent().getStringExtra(Title);

		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.getSettings().setLoadWithOverviewMode(true);
		mWebView.getSettings().setUseWideViewPort(true);
		mWebView.setPadding(0, 0, 0, 0);

		createCustomActionBarTitle();

		connection = connectDetect.isNetworkAvailable();

		if (connection) {
			mWebView.setWebViewClient(new WebClientCreate());
			mWebView.getSettings().setJavaScriptEnabled(true);

			// mWebView.setWebChromeClient(new WebChromeClient() {
			// @Override
			// public void onProgressChanged(WebView view, int newProgress) {
			// super.onProgressChanged(view, newProgress);
			//
			// //mProgressBar.setProgress(newProgress * 100);
			// // activity.setTitle("Loding.....");
			// // activity.setProgress(newProgress * 100);
			// // if (newProgress == 100)
			// //
			//
			// }
			// });

			mWebView.loadUrl(getUrl);

		} else {
			Toast.makeText(getApplicationContext(), "Internet Connect Error !",
					Toast.LENGTH_LONG).show();
		}

	}

	public class WebClientCreate extends WebViewClient {
		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);
			mProgressBar.setVisibility(View.VISIBLE);
		}

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			view.loadUrl(url);
			return true;

		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);
			mProgressBar.setVisibility(View.GONE);
		}
	}

	@Override
	public void onBackPressed() {
		if (mWebView.canGoBack()) {
			mWebView.goBack();
		} else {
			super.onBackPressed();
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		mWebView.saveState(outState);
		Log.i(TAG, "onSaveInstanceState");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		mWebView.restoreState(savedInstanceState);
		Log.i(TAG, "onRestoreInstanceState");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.web_view, menu);

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case R.id.action_home:
			Intent intent = new Intent(BanglaWebView.this, StartActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			break;
		case R.id.action_refresh:
			mWebView.reload();
		}
		return true;
	}

	private void createCustomActionBarTitle() {
		this.getActionBar().setDisplayShowCustomEnabled(true);
		this.getActionBar().setDisplayShowTitleEnabled(false);

		LayoutInflater inflator = LayoutInflater.from(this);
		View v = inflator.inflate(R.layout.custom_actionbar_title, null);

		TextView tv = (TextView) v.findViewById(R.id.custom_font);
		tv.setText(getTitle);
		tv.setTypeface(Typeface.createFromAsset(getAssets(), FONT));

		// assign the view to the actionbar
		this.getActionBar().setCustomView(v);
	}

}
