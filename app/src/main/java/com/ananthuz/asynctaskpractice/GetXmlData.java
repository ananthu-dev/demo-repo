package com.ananthuz.asynctaskpractice;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ananthakrishnan on 02-07-2017.
 */

public class GetXmlData {

    private String LOG_TAG= GetXmlData.class.getSimpleName();
    private String url;
    private String xmlData;

    public GetXmlData(String url) {
        this.url = url;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void execute(){
        DownloadXmlData downloadXmlData=new DownloadXmlData();
        downloadXmlData.execute(url);
    }

    public class DownloadXmlData extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... strings) {

            HttpURLConnection urlConnection=null;
            BufferedReader reader=null;

            if (strings==null){return null;}
            try{
                URL url = new URL(strings[0]);
                urlConnection= (HttpURLConnection)url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();
                InputStream inputStream=urlConnection.getInputStream();
                StringBuffer stringBuffer=new StringBuffer();
                reader=new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while ((line=reader.readLine())!=null){
                    stringBuffer.append(line+"\n");

                }
                return stringBuffer.toString();


            }catch (IOException e){
                Log.d(LOG_TAG,"Error Occured: "+ e);
                return null;

            }finally {
                if (urlConnection!=null){
                    urlConnection.disconnect();
                }
            }
        }

        @Override
        protected void onPostExecute(String downloadedData) {
            super.onPostExecute(downloadedData);
            xmlData= downloadedData;
            Log.d(LOG_TAG,"The data downloaded is: "+xmlData);
        }
    }
}
