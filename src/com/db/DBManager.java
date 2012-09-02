package com.db;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.count;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	
	private DatabaseHelper dbhelper;
	private SQLiteDatabase db;
	
	public DBManager(Context context) {
		dbhelper = new DatabaseHelper(context);
		db = dbhelper.getWritableDatabase();
	}
	
	/**
	 * add count
	 */
	public void addCount(count c) {
		
		/**
		 * add a count.
		 */
		db.beginTransaction();
		try {
			String name = c.name;
			String date =  c.countdate;
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ContentValues values = new ContentValues();
			
			values.put("name", name);
			values.put("countdate", dateFormat.format(date));
			
			db.insert("count", null, values);
		}
		finally {
			db.endTransaction();
		}
	}
	
	public void updatename(count c) {
		/**
		 * modify the name of a count.
		 */
		ContentValues values = new ContentValues();
		String name = c.name;
		values.put("name", name);
		db.update("count", values, "name = ?", new String[]{c.name});
	}
	
	public void deleteCount(count c) {
		/**
		 * delete a count.
		 */
		db.delete("count", "id == ?",  new String[]{Integer.toString(c.id)});
	}
	
	public List<count> querycount() {
		/**
		 * get a count obj in the table.
		 */
		ArrayList<count> counts = new ArrayList<count>();
		
		Cursor curs = queryTheCursor("count");
		// walk the count table.
		while(curs.moveToNext()) {
			count c = new count();
			c.id = curs.getInt(curs.getColumnIndex("id"));
			c.name = curs.getString(curs.getColumnIndex("name"));
			c.countdate = curs.getString(curs.getColumnIndex("countdate"));
			
			counts.add(c);
		}
		
		curs.close();
		return counts;
	}

	private Cursor queryTheCursor(String tablename) {
		/**
		 * get cursor of a table.
		 */
		String str_select = "SELECT * FROM " + tablename;
		Cursor c = db.rawQuery(str_select, null);
		return c;
	}
	
	public void closeDB() {
		/**
		 * close a db.
		 */
		db.close();
	}
}
