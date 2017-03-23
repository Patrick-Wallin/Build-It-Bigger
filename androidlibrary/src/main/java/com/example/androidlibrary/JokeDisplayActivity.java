package com.example.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class JokeDisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView tv = (TextView)findViewById(R.id.joke_text_view);

        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.joke_story))) {
            tv.setText(intent.getStringExtra(getString(R.string.joke_story)));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
