package com.col.commo.images;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by commo on 2017/5/16.
 */

public class Mp3Util {

    public static List<Mp3> getMp3(Context context){

        Cursor cursor = context.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,null,null,MediaStore.Audio.Media.DEFAULT_SORT_ORDER);

        List<Mp3> mp3s = new ArrayList<Mp3>();

        for( int i = 0 ; i < cursor.getCount() ; i ++ ){
            cursor.moveToNext();
            Mp3 mp3 = new Mp3();
            String title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE));
            String artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST));
            String url = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA));
            int isMusic = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.Media.IS_MUSIC));

            if ( isMusic != 0){
                mp3.setTitle(title);
                mp3.setArtist(artist);
                mp3.setUrl(url);

                mp3s.add(mp3);
            }
        }

        return mp3s;

    }

    public static List<HashMap<String,String>> getMusicMaps(List<Mp3> mp3s){
        List<HashMap<String,String>> mp3list = new ArrayList<HashMap<String, String>>();

        for (Iterator iterator = mp3s.iterator(); iterator.hasNext();){
            Mp3 mp3 = (Mp3) iterator.next();
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("title",mp3.getTitle());
            map.put("artist",mp3.getArtist());
            map.put("url",mp3.getUrl());
            mp3list.add(map);
        }

        return mp3list;
    }
}
