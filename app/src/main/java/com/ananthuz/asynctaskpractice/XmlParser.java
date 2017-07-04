package com.ananthuz.asynctaskpractice;

import android.content.Context;
import android.util.Log;
import android.widget.Switch;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ananthakrishnan on 02-07-2017.
 */

public class XmlParser extends GetXmlData{

    private String LOG_TAG=XmlParser.class.getSimpleName();
    public static String xmlData;
    private String webUrl;
    private ArrayList<PhotoDetails> photos;

    public XmlParser() {
        super(null);
        photos= new ArrayList<>();
    }

    public void execute(){
        //super.setUrl("https://api.flickr.com/services/feeds/photos_public.gne?format=xml&tags=doggo");
        DownloadDataToParseClass downloadDataToParseClass= new DownloadDataToParseClass();
        downloadDataToParseClass.execute();

    }




    public class DownloadDataToParseClass extends DownloadXmlData{

        @Override
        protected void onPostExecute(String downloadedData) {
            xmlData=downloadedData;
            Log.d("xmldata", "The data downloaded is:"+xmlData);
            super.onPostExecute(downloadedData);
        }

        @Override
        protected String doInBackground(String... strings) {
            return super.doInBackground("https://api.flickr.com/services/feeds/photos_public.gne?format=xml&tags=doggo");
        }
    }


}
