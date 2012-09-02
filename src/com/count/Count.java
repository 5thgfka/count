package com.count;

import com.db.DBManager;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

/**
 * 天下事渺茫如此，古今人大概相同。
 * @author ekse
 * @version 0.0
 */
public class Count extends Activity {
	/** 
	 * 1.view history button onclick listener
	 * 2.add new count button onclick listener
	 */
	OnClickListener viewHistoryListener = null;
	OnClickListener addNewListener = null;
	
	/**
	 * 1.button HISTORY
	 * 2.button CREATE NEW
	 * 3.button QUIT
	 */
	Button btn_viewHistory;
	Button btn_addNew;
	
	private DBManager mgr;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        mgr = new DBManager(this);
        
        addNewListener = new OnClickListener() {
        	public void onClick(View v) {
        		Intent main2newIntent = new Intent(Count.this, countNew.class);
        		setTitle("New");
        		startActivity(main2newIntent);
        	}
        };
        
        viewHistoryListener = new OnClickListener() {
        	public void onClick(View v) {
        		Intent main2historyIntent = new Intent(Count.this, countHistory.class);
        		setTitle("History");
        		startActivity(main2historyIntent);
        	}
        };
        // display page
        setContentView(R.layout.main);
        // bind button
        btn_addNew = (Button) findViewById(R.id.create);
        btn_viewHistory = (Button) findViewById(R.id.history);
        // bind button with listener
        btn_addNew.setOnClickListener(addNewListener);
        btn_viewHistory.setOnClickListener(viewHistoryListener);
    }
    
    protected void onDestroy() {
    	super.onDestroy();
    	mgr.closeDB();
    }
}