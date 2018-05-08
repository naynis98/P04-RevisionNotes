package com.myapplicationdev.android.p04_revisionnotes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class SecondActivity extends AppCompatActivity {

	ListView lv;
	ArrayList<Note> al;
	ArrayAdapter<Note> aa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//TODO implement the Custom ListView
		setContentView(R.layout.activity_second);

		lv = (ListView)findViewById(R.id.lv);

        // activity's Context
        DBHelper db = new DBHelper(SecondActivity.this);

        // Insert a task
        al = db.getAllNotes();
        db.close();
        aa = new RevisionNotesArrayAdapter(SecondActivity.this, R.layout.row, al);
        lv.setAdapter(aa);
	}


}
