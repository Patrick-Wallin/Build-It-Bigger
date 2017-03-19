package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.util.Pair;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.androidlibrary.JokeDisplayActivity;
import com.example.piwal.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by piwal on 3/14/2017.
 */

public class EndpointsAsyncTask extends AsyncTask<Pair<Context,String>,Void,String> {
    private static MyApi myApiService = null;
    private Context context;
    private ProgressBar mProgressBar;

    public EndpointsAsyncTask(ProgressBar progressBar) {
        mProgressBar = progressBar;
    }


    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(),null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            myApiService = builder.build();
        }

        context = params[0].first;

        try {
            return myApiService.getJoke().execute().getData();
        }catch(IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(mProgressBar != null)
            mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(String s) {
        //Toast.makeText(context,s,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(context, JokeDisplayActivity.class);
        intent.putExtra(context.getString(R.string.joke_story), s);
        context.startActivity(intent);
        if(mProgressBar != null)
            mProgressBar.setVisibility(View.GONE);

    }
}
