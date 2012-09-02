package com.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "count.db";
	private static final int DATABASE_VERSION = 1;
	
	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// Initial SQL String
		String createCountSQL = "CREATE TABLE IF NOT EXISTS count"+
		"(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, countdate date)";
		String createVoteSQL = "CREATE TABLE IF NOT EXISTS vote"+
		"(id INTEGER PRIMARY KEY AUTOINCREMENT, countid INTEGER, name VARCHAR, times INTEGER)";
		// create tables
		db.execSQL(createCountSQL);
		db.execSQL(createVoteSQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
