package com.ananthuz.asynctaskpractice;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GetXmlData getXmlData = new GetXmlData("https://api.flickr.com/services/feeds/photos_public.gne?format=xml&tags=doggo");
        getXmlData.execute();

    }

}





