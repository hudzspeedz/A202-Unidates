package com.coventery.jack.unidatesapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.coventery.jack.unidatesapp.app.DatabaseHandler;
import com.coventery.jack.unidatesapp.app.MatchHandler;

/**
 * Created by user on 12/03/2016.
 */
public class MatchViewAdapter extends BaseAdapter {
    private final String[] Fnames;
    private final String[] Ages;
    private final String[] Unis;
    private final String[] Urls;
    private Context context;
    private int layoutResourceId;
    MatchHandler mh;



    public MatchViewAdapter(Context context, int layoutResourceId, String[] Fnames, String[] Ages, String[] Unis, String[] Urls, MatchHandler mh) {

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.Fnames = Fnames;
        this.Ages = Ages;
        this.Unis = Unis;
        this.Urls = Urls;
        this.mh = mh;


    }

    @Override
    public int getCount() {

        long allusers = mh.getUserCount();
        int intallusers = (int)allusers;

         return intallusers ;
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
        View row = convertView;
        ViewHolder holder = null;

        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ViewHolder();
            holder.name = (TextView) row.findViewById(R.id.MGname);
            holder.age = (TextView) row.findViewById(R.id.MGage);
            holder.uni = (TextView) row.findViewById(R.id.MGuni);
            holder.image = (ImageView) row.findViewById(R.id.imageView2);
            holder.image.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }


        new GetXMLTask(holder.image).execute(Urls[position]);
        holder.name.setText(Fnames[position]);
        holder.age.setText(Ages[position]);
        holder.uni.setText(Unis[position]);

        return row;
    }

    static class ViewHolder {
        TextView name;
        TextView age;
        TextView uni;
        ImageView image;
    }

}