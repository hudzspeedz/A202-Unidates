package com.coventery.jack.unidatesapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 * Created by user on 12/03/2016.
 */
public class GridViewAdapter extends BaseAdapter {
    private final String[] Fnames;
    private final String[] Ages;
    private final String[] Unis;
    private final String[] Urls;
    private Context context;
    private int layoutResourceId;

    public GridViewAdapter(Context context, int layoutResourceId, String[] Fnames, String[] Ages, String[] Unis, String[] Urls) {

        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.context = context;
        this.Fnames = Fnames;
        this.Ages = Ages;
        this.Unis = Unis;
        this.Urls = Urls;

    }

    @Override
    public int getCount() {
        return Fnames.length;
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
            holder.name = (TextView) row.findViewById(R.id.TVSGname);
            holder.age = (TextView) row.findViewById(R.id.TVSGage);
            holder.uni = (TextView) row.findViewById(R.id.TVSGuni);
            holder.image = (ImageView) row.findViewById(R.id.imageView);
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

   /* private class GetXMLTask extends AsyncTask<String, Void, Bitmap> {

        private final WeakReference<ImageView> imageViewReference;

        protected GetXMLTask(ImageView imageView) {
            imageViewReference = new WeakReference <ImageView> (imageView);
        }

        @Override
        protected Bitmap doInBackground(String... urls) {
            Bitmap map = null;
            for (String url : urls) {
                map = downloadImage(url);
            }
            return map;
        }

        // Sets the Bitmap returned by doInBackground
        @Override
        protected void onPostExecute(Bitmap result) {

            if (imageViewReference != null && result != null) {
                final ImageView imageView = imageViewReference.get();
                if (imageView != null) {
                    imageView.setImageBitmap(result);
                }
            }
        }

        // Creates Bitmap from InputStream and returns it
        private Bitmap downloadImage(String url) {
            Bitmap bitmap = null;
            InputStream stream = null;
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            bmOptions.inSampleSize = 1;

            try {
                stream = getHttpConnection(url);
                bitmap = BitmapFactory.
                        decodeStream(stream, null, bmOptions);
                stream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return bitmap;
        }

        // Makes HttpURLConnection and returns InputStream
        private InputStream getHttpConnection(String urlString)
                throws IOException {
            InputStream stream = null;
            URL url = new URL(urlString);
            URLConnection connection = url.openConnection();

            try {
                HttpURLConnection httpConnection = (HttpURLConnection) connection;
                httpConnection.setRequestMethod("GET");
                httpConnection.connect();

                if (httpConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    stream = httpConnection.getInputStream();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            return stream;
        }
    }*/
}