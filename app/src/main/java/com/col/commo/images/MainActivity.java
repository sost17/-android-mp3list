package com.col.commo.images;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView list_mp3;
    private MusicAdapter adapter;
    private List<Mp3> listmp3 = null;

    private ImageView music;
    private TextView title,atrist,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list_mp3 = (ListView) findViewById(R.id.list);
        music = (ImageView) findViewById(R.id.cover);
        title = (TextView) findViewById(R.id.title);
        atrist = (TextView) findViewById(R.id.artist);
        url = (TextView) findViewById(R.id.path);

        listmp3 = Mp3Util.getMp3(MainActivity.this);
        adapter = new MusicAdapter(this,listmp3);
        list_mp3.setAdapter(adapter);

    }


}
