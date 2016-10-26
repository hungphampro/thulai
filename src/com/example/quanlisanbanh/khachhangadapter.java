package com.example.quanlisanbanh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class khachhangadapter extends ArrayAdapter<khachhang>{
    private Activity context;
    private int layoutid;
    private ArrayList<khachhang> object;
	public khachhangadapter(Activity context, int resource, ArrayList<khachhang> objects) {
		super(context, resource, objects);
		this.context=context;
		this.layoutid=resource;
		this.object=objects;
		}
@Override
public View getView(int position, View convertView, ViewGroup parent)
{
	convertView=context.getLayoutInflater().inflate(layoutid, null);
	TextView hung=(TextView)convertView.findViewById(R.id.txtday);
	TextView canh=(TextView) convertView.findViewById(R.id.txtgio);
	TextView anh=(TextView)  convertView.findViewById(R.id.txtname);
	TextView hoa=(TextView)  convertView.findViewById(R.id.txtvtds);
	TextView hong=(TextView)  convertView.findViewById(R.id.txtphone);
	khachhang kh=object.get(position);
	hung.setText("Ngày:"+kh.getngay());
	canh.setText("Giờ:"+kh.getgio());
	anh.setText("Tên Khách:"+kh.getten());
	hoa.setText("Tên Sân:"+kh.getvtds());
	hong.setText("Số Điện Thoại:"+kh.getsdt());
	return convertView;
}
}
