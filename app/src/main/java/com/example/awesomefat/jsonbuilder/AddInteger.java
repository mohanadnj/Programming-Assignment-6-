package com.example.awesomefat.jsonbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddInteger extends AppCompatActivity {

    private EditText nameEx;
    private EditText valueEx;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_integer);

        this.nameEx = (EditText)this.findViewById(R.id.nameEx);
        this.valueEx = (EditText)this.findViewById(R.id.valueEx);
    }

    public void saveButtonPressed(View v)
    {
        BuilderCore.currentBuildJSONObjectActivity.addNameValuePair(this.nameEx.getText().toString(), this.valueEx.getText().toString());
        this.onBackPressed();
    }
    public void AddToObjectbotton(View v)
    {
        BuilderCore.currentAddObject.addNameValuePair(this.nameEx.getText().toString(), this.valueEx.getText().toString());
        this.onBackPressed();
        BuilderCore.currentBuildJSONObjectActivity.addNameValuePair(this.nameEx.getText().toString(), this.valueEx.getText().toString());
        this.onBackPressed();
    }
}
