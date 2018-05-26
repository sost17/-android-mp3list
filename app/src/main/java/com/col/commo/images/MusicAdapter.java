package com.col.commo.images;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by commo on 2017/5/16.
 */

public class MusicAdapter extends BaseAdapter {

    private Context context;
    private List<Mp3> Mp3s;
    private Mp3 mp3;

    public MusicAdapter(Context context,List<Mp3> Mp3s){
        this.context = context;
        this.Mp3s = Mp3s;
    }
    @Override
    public int getCount() {
        return Mp3s.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if(convertView == null){
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.artist = (TextView) convertView.findViewById(R.id.artist);
            viewHolder.url = (TextView) convertView.findViewById(R.id.path);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        mp3 = Mp3s.get(position);
        viewHolder.title.setText(mp3.getTitle());
        viewHolder.artist.setText(mp3.getArtist());
        viewHolder.url.setText(mp3.getUrl());

        return convertView;
    }

    public class ViewHolder{
        public TextView title;
        public TextView artist;
        public TextView url;

    }
}
