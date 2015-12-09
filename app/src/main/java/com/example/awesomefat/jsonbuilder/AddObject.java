package com.example.awesomefat.jsonbuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class AddObject extends AppCompatActivity {

    private EditText nameET;
    private EditText valueET;
    private ListView theListView;
    private ArrayAdapter<String> theArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_object);
        this.nameET = (EditText)this.findViewById(R.id.nameET);
        this.valueET = (EditText)this.findViewById(R.id.valueET);
        this.theListView = (ListView)this.findViewById(R.id.theListView);
        this.theArrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_table_row, R.id.rowText);
        this.theListView.setAdapter(this.theArrayAdapter);
    }

    public void addNameValuePairButtonPressed(View v)
    {
        BuilderCore.currentAddObject = this;
        Intent i = new Intent(this, CreateNameValueActivity.class);
        this.startActivity(i);
    }
    public void addInteger(View v)
    {
        BuilderCore.currentAddObject = this;
        Intent i = new Intent(this, AddInteger.class);
        this.startActivity(i);
    }

    public void addNameValuePair(String name, String value)
    {
        this.theArrayAdapter.add(name + ":" + value);
    }

    public void saveButtonPressed(View v)
    {
        this.onBackPressed();
    }


}
