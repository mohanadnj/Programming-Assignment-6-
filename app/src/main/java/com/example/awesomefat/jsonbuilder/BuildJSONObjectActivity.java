package com.example.awesomefat.jsonbuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class BuildJSONObjectActivity extends AppCompatActivity
{
    private ListView theListView;
    private ArrayAdapter<String> theArrayAdapter;
    private ArrayAdapter<String> theArrayAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_jsonobject);
        this.theListView = (ListView)this.findViewById(R.id.theListView);

        this.theArrayAdapter = new ArrayAdapter<String>(this, R.layout.simple_table_row, R.id.rowText);
        this.theListView.setAdapter(this.theArrayAdapter);
    }
    public void addNameInteger(String name, String value)
    {
        this.theArrayAdapter.add(name + ":" + value);
    }
    public void addNameValuePair(String name, String value)
    {
        this.theArrayAdapter.add(name + ":" + value);
    }

    public void addNameObject(View v)
    {
        BuilderCore.currentBuildJSONObjectActivity = this;
        Intent i = new Intent(this, AddObject.class);
        this.startActivity(i);
        this.theArrayAdapter2 = new ArrayAdapter<String>(this, R.layout.simple_table_row, R.id.rowText);

    }
    public void addNameValuePairButtonPressed(View v)
    {
        BuilderCore.currentBuildJSONObjectActivity = this;
        Intent i = new Intent(this, CreateNameValueActivity.class);
        this.startActivity(i);
    }
    public void addInteger(View v)
    {
        BuilderCore.currentBuildJSONObjectActivity = this;
        Intent i = new Intent(this, AddInteger.class);
        this.startActivity(i);
    }

    public void addarray(View v)
    {
        BuilderCore.currentBuildJSONObjectActivity = this;
        Intent i = new Intent(this, addarray.class);
        this.startActivity(i);
    }

    public void generateJSONButtonPressed(View v)
    {
        //create the JSON string
        String answer = "{\n";
        for(int i = 0; i < this.theArrayAdapter.getCount(); i++)
        {
            String[] parts = this.theArrayAdapter.getItem(i).split(":");
            answer += "\t" + "\"" + parts[0] + "\" : \"" + parts[1] + "\"";
            if(i != this.theArrayAdapter.getCount()-1)
            {
                answer += ",\n";
            }
            else
            {
                answer += "\n";
            }
        }
        answer += "}";
        BuilderCore.theJSON = answer;
        Intent i = new Intent(this, GenerateJSONActivity.class);
        this.startActivity(i);
    }
}
