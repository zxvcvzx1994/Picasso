package com.example.kh.myapplication.Module;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kh.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by kh on 5/4/2017.
 */

public class Person {
    private String  img;
    private String ten;
    public Person(String ten, String img){
        this.ten = ten;
        this.img  = img;
    }
    public Person(){

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
    public static class Myadapter extends ArrayAdapter<Person> {
        private Context context;
        private int resource;

        private ArrayList<Person> arrayList  = new ArrayList<Person>();
        private ProgressBar progressBar;
        private LayoutInflater inflater;
        public Myadapter(@NonNull Context context, @LayoutRes int resource,@NonNull ArrayList<Person> object) {
            super(context, resource, object);
            this.context = context;
            this.resource = resource;
            this.arrayList = object;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View view = convertView;
            ViewHolder holder = null;

            if(view==null){
                inflater  = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(resource,null);
                holder  = new ViewHolder();
                holder.txt  = (TextView) view.findViewById(R.id.txt);
                holder.img = (ImageView) view.findViewById(R.id.img);
                holder.progressBar = (ProgressBar) view.findViewById(R.id.progressbar);

                view.setTag(holder);

            } else holder  = (ViewHolder) view.getTag();
            holder.txt.setText(arrayList.get(position).getTen());
            Picasso.with(context).load(arrayList.get(position).getImg())
                    .placeholder(R.mipmap.ic_launcher_round)
                    .into(holder.img);


            return view;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return getView(position, convertView, parent);
        }

        private class ViewHolder{
            private ProgressBar progressBar;
            private TextView txt;
            private ImageView img;
        }
    }
}
