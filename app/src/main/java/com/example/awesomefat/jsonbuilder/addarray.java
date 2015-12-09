package com.example.awesomefat.jsonbuilder;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class addarray extends AppCompatActivity {
    private EditText objectnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addarray);
        this.objectnum = (EditText)this.findViewById(R.id.objectnum);

    }
    public void addNameObject(View v) {
        BuilderCore.currentaddarray = this;
        Intent i = new Intent(this, AddObject.class);
        this.startActivity(i);
    }
    public void saveButtonPressed(View v)
    {
        this.onBackPressed();
    }

}
