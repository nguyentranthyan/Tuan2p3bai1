package com.example.student.tuan2p3bai1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<NhanVien> {
Activity context=null;
ArrayList<NhanVien> myArray=null;
int layoutId;
    public MyArrayAdapter(Activity context, int textViewResourceId, ArrayList<NhanVien> object) {
        super(context,textViewResourceId,object);
        this.context=context;
        this.layoutId=textViewResourceId;
        this.myArray=object;
    }

    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(layoutId,null);
        if(myArray.size()>0 && position>=0){
            final TextView txtDisplay= convertView.findViewById(R.id.tv_item);
            final NhanVien nv=myArray.get(position);
            txtDisplay.setText(nv.toString());
            final ImageView imageitem=convertView.findViewById(R.id.img_item);
            if(nv.isGender()){
                imageitem.setImageResource(R.drawable.nu);
            }else{
                imageitem.setImageResource(R.drawable.nam);
            }
        }
        return convertView;
    }
}
