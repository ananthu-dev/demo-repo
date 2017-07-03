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
    private String xmlData;
    private ArrayList<PhotoDetails> photos;

    public XmlParser() {
        super(null);
        xmlData=getXmlData();
        photos= new ArrayList<PhotoDetails>();
    }


    public void process(){

        PhotoDetails currentRecord=null;
        boolean inEntry=false;
        boolean inAuthor=false;
        String textValue="";
        String tagName=null;
        try{
            XmlPullParserFactory xmlPullParserFactory= XmlPullParserFactory.newInstance();
            xmlPullParserFactory.setNamespaceAware(true);
            XmlPullParser xmlPullParser=xmlPullParserFactory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));
            int eventType=xmlPullParser.getEventType();
            while (eventType!=xmlPullParser.END_DOCUMENT){

                tagName=xmlPullParser.getName();
                switch (eventType){

                    case XmlPullParser.START_TAG:{
                        Log.d(LOG_TAG,"Starting tag for: "+ tagName);
                        if (tagName.equalsIgnoreCase("entry")){
                            inEntry=true;
                            currentRecord=new PhotoDetails();
                        }
                        break;
                    }
                    case XmlPullParser.TEXT: {
                        textValue = xmlPullParser.getText();
                        break;
                    }
                    case XmlPullParser.END_TAG:{
                        if (inEntry){
                            if (tagName.equalsIgnoreCase("entry")){
                                photos.add(currentRecord);
                                inEntry=false;
                            }else if (tagName.equalsIgnoreCase("title")){
                                currentRecord.setTitle(textValue);
                            }else if (tagName.equalsIgnoreCase("link")){
                                currentRecord.setPost_link(textValue);
                            }else if (tagName.equalsIgnoreCase("id")){
                                currentRecord.setPostid(textValue);
                            } else if (tagName.equalsIgnoreCase("content")){
                                currentRecord.setContent(textValue);
                            }else if (tagName.equalsIgnoreCase("author")) {
                                inAuthor = true;
                                if (inAuthor) {
                                    inAuthor = false;
                                    if (tagName.equalsIgnoreCase("name")) {
                                        currentRecord.setAuthor_name(textValue);
                                    } else if (tagName.equalsIgnoreCase("flickr:nsid")) {
                                        currentRecord.setAuthor_id(textValue);
                                    }
                                }
                            } else if (tagName.equalsIgnoreCase("link")){
                                currentRecord.setPicture_link(textValue);
                            }
                        }
                        break;
                    }
                    default:
                }
                eventType=xmlPullParser.next();

            }


        }catch (XmlPullParserException e){
            Log.d(LOG_TAG,"XmlPulparserException, error is: "+ e);
        }catch (IOException e){
            Log.d(LOG_TAG,"IOException, error is: "+e);
        }

        for (PhotoDetails singlePhoto: photos){
            Log.d(LOG_TAG,"***************************");
            Log.d(LOG_TAG,"Title: "+ singlePhoto.getTitle());
            Log.d(LOG_TAG,"Post Link: "+ singlePhoto.getPost_link());
            Log.d(LOG_TAG,"Post ID: "+ singlePhoto.getPostid());
            Log.d(LOG_TAG,"Content: "+ singlePhoto.getContent());
            Log.d(LOG_TAG,"Author name: "+ singlePhoto.getAuthor_name());
            Log.d(LOG_TAG,"Author ID: "+ singlePhoto.getAuthor_id());
            Log.d(LOG_TAG,"Picture Link: "+singlePhoto.getPicture_link());
        }

    }
}
