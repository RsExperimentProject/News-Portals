package com.ramananda.bean;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectDetect {
	private Context _context;

	public ConnectDetect(Context context) {
		this._context = context;
	}

	public boolean isNetworkAvailable() {
		ConnectivityManager cManager = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = cManager.getActiveNetworkInfo();
		if (networkInfo != null) {
			if (networkInfo.isAvailable() && networkInfo.isConnected()) {
				return true;
			}
		}
		return false;
	}
}
