package com.ananthuz.asynctaskpractice;

/**
 * Created by Ananthakrishnan on 02-07-2017.
 */

public class PhotoDetails {

    /**The below variables represent each tag in the xml file recieved from flickr
    using the class GetXmlData.*/


    private String title, post_link,picture_link,postid,content,author_name, author_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostLink() {
        return post_link;
    }

    public void setLink(String link) {
        this.post_link = link;
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getPost_link() {
        return post_link;
    }

    public void setPost_link(String post_link) {
        this.post_link = post_link;
    }

    public String getPicture_link() {
        return picture_link;
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    @Override
    public String toString() {
        return "PhotoDetails{" +
                "title='" + title + '\'' +
                ", post_link='" + post_link + '\'' +
                ", picture_link='" + picture_link + '\'' +
                ", postid='" + postid + '\'' +
                ", content='" + content + '\'' +
                ", author_name='" + author_name + '\'' +
                ", author_id='" + author_id + '\'' +
                '}';
    }
}
