package com.example.btnewsfetch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;



//note: you must put  android:configChanges="orientation|screenSize" in the manifest
public class MainActivity extends Activity  {

	// %%%%%%%%%%%%%% PHASE 0
	private static final String GOOGLE_SEARCH = "https://www.google.com/search?q=";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// %%%%%%%%%%%%%% PHASE 0
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}







}
