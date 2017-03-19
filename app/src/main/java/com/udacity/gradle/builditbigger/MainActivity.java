package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.JokeStory;
import com.example.androidlibrary.JokeDisplayActivity;


public class MainActivity extends AppCompatActivity {
    ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportFragmentManager().beginTransaction().add(R.id.fragment,new MainActivityFragment()).commit();
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        //JokeStory jokeStory = new JokeStory();
        //Toast.makeText(this,jokeStory.getJokeStory(), Toast.LENGTH_LONG).show();
        //Step 2 wanted me to go to another activity and display joke instead of Toast.
        //Step 3 wanted me to use GCE Module to get joke and pass it to Joke Display Activity instead
        //of using JokeStory.
        //Intent intent = new Intent(this, JokeDisplayActivity.class);
        //intent.putExtra(getString(R.string.joke_story), jokeStory.getJokeStory());
        //startActivity(intent);
        new EndpointsAsyncTask(mProgressBar).execute(new Pair<Context,String>(this,"Manfred"));

    }


}
