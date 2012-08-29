package com.count;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class countNew extends Activity {
	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 * @summary create new count
	 * 
	 */
	/** 
	 * 1.ok button onclick listener
	 * 2.cancel button onclick listener
	 */
	OnClickListener okBTNListener = null;
	OnClickListener nokBTNListener = null;
	
	/**
	 * 1.ok button
	 * 2.nok button
	 */
	Button btn_ok;
	Button btn_cancel;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		okBTNListener = new OnClickListener() {
        	public void onClick(View v) {
        		Intent new2workIntent = new Intent(countNew.this, countCounting.class);
        		setTitle("Count");
        		startActivity(new2workIntent);
        	}
        };
        
        nokBTNListener = new OnClickListener() {
        	public void onClick(View v) {
        		Intent new2mainIntent = new Intent(countNew.this, Count.class);
        		setTitle("Count");
        		startActivity(new2mainIntent);
        	}
        };
        setContentView(R.layout.countnewlayout);
        // bind button
        btn_ok = (Button) findViewById(R.id.btnewok);
        btn_cancel = (Button) findViewById(R.id.btnewcancel);
        // bind button with listener
        btn_ok.setOnClickListener(okBTNListener);
        btn_cancel.setOnClickListener(nokBTNListener);
	}
}
