package com.col.commo.images;

/**
 * Created by commo on 2017/5/15.
 */

public class Mp3 {

    String title ;
    String artist ;
    String url ;

    public Mp3(){
        super();
    }

    public Mp3(String title,String artist,String url){
        super();
        this.title = title;
        this.artist = artist;
        this.url = url;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }




}
