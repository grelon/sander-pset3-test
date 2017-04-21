package com.example.sander.sander_pset3_test;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText eMovie;
    ListView lvMyMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eMovie = (EditText) findViewById(R.id.eMovie);
        assert eMovie != null;
    }

    public void movieSearch(View view) {
        String movieSearch = eMovie.getText().toString();
        MovieAsyncTask asyncTask = new MovieAsyncTask(this);
        asyncTask.execute(movieSearch);

        eMovie.getText().clear();
    }

    public void movieStartIntent(JSONObject movieData) {
        Intent dataIntent = new Intent(this, DataActivity.class);
        dataIntent.putExtra("data", movieData.toString());
        startActivity(dataIntent);
    }
}
