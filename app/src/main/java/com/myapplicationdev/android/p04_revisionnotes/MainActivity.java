package com.myapplicationdev.android.p04_revisionnotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textViewNote;
    EditText editTextNote;
    TextView textView2;
    RadioGroup radioGroupStars;
    Button buttonInsertNote;
    Button buttonShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNote = (TextView) findViewById(R.id.textViewNote);
        editTextNote = (EditText) findViewById(R.id.editTextNote);
        textView2 = (TextView) findViewById(R.id.textView2);
        radioGroupStars = (RadioGroup) findViewById(R.id.radioGroupStars);
        buttonInsertNote = (Button) findViewById(R.id.buttonInsertNote);
        buttonShowList = (Button) findViewById(R.id.buttonShowList);

        buttonInsertNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create the DBHelper object, passing in the activity's context
                DBHelper db = new DBHelper(MainActivity.this);

                int selectedButtonId = radioGroupStars.getCheckedRadioButtonId();
                RadioButton rb =(RadioButton) findViewById(selectedButtonId);
                //insert a task
                db.insertNote(editTextNote.getText().toString(),Integer.parseInt(rb.getText().toString()));
                db.close();
                Toast toast = Toast.makeText(MainActivity.this, "Inserted",Toast.LENGTH_SHORT);
                toast.show();
            }
        });

            buttonShowList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(i);
                }
            });


    }
}
