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
public class MainActivity extends Activity implements OnItemSelectedListener,
		OnClickListener {


	private static final String GOOGLE_SEARCH = "https://www.google.com/search?q=";
	// 1 declare references to UI objects
	EditText edtSubject;
	Spinner spnSite;
	Button btnFetch, btnBack, btnNext;
	WebView wbvResult;
	String strSite;
	String strBuiltUrl;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// get references to the inflated objects
		edtSubject = (EditText) findViewById(R.id.edtSubject);
		spnSite = (Spinner) findViewById(R.id.spnSite);
		btnFetch = (Button) findViewById(R.id.btnFetch);
		btnBack = (Button) findViewById(R.id.btnBack);
		btnNext = (Button) findViewById(R.id.btnNext);
		wbvResult = (WebView) findViewById(R.id.wbvResult);

		spnSite.setOnItemSelectedListener(this);
		btnFetch.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		
		
		wbvResult = (WebView) findViewById(R.id.wbvResult);

		// first time only
		if (savedInstanceState == null) {
			spnSite.setSelection(0);
			strSite = "news.google.com";
		}
	}

	// ################################################
	// Used for ActionBar
	// ################################################
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	    case R.id.action_exit:

	    	finish();
	    	
	      break;
	   
	    default:
	      break;
	    }

	    return true;
	  } 

	// ################################################
	// IMPLEMENTED METHODS OF OnItemSelectedListener
	// ################################################
	@Override
	public void onItemSelected(AdapterView<?> parent, View vwx, int pos, long id) {
		strSite = parent.getItemAtPosition(pos).toString();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}

	// ################################################
	// IMPLEMENTED METHOD OF OnClickListener
	// ################################################
	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnBack:
			if (wbvResult.canGoBack())
				wbvResult.goBack();
			break;
		case R.id.btnNext:
			if (wbvResult.canGoForward())
				wbvResult.goForward();
			break;
			
		case R.id.btnFetch:
			strBuiltUrl = "site:" + strSite + "+" + edtSubject.getText().toString();
			wbvResult.loadUrl(GOOGLE_SEARCH + spacesToPluses(strBuiltUrl));
			break;
		default:
			break;
		}
	}

	//helper method
	private String spacesToPluses(String strOrig) {

		String strMod = "";
		for (char cChar : strOrig.toCharArray()) {
			if (cChar == 32) {
				strMod += "+";
			} else {
				strMod += cChar;
			}
		}
		return strMod;
	}

}
