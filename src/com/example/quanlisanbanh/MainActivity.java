package com.example.quanlisanbanh;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {
     private TabHost dailoai;
     private TextView lichdat,tennd,sdtnd,vtds,tgdatngay,tgdatgio;
     private EditText ghiten,ghiso,ghivtds;
     private ListView taucungchabiet;
     private Spinner hung,khong,so;
     private khachhang kh;
     private ListView listview;
     private khachhangadapter adapter;
     TabHost.TabSpec spec;
      TabHost tab;
      int m,n,k;
     private ArrayList<khachhang> sana1,sana2,sana3,sanb1,sanb2,sanb3,sanc1,sanc2,tongquat;
     Button list;
     String arg[]={
    		    
				"Hôm Nay",
				"Ngày Mai",
				"Ngày Mốt",
				"Ngày Kia",
				"Ngày Kĩa",
				"Ngày Kìa",
				"1 Tuần sau"
		},arg2[]={
    		    
				"A1","A2","A3",
				"B1","B2","B3",
				"C1","C2"},
				arg1[]={
    		    
				"5:30",
				"6:30",
				"7:30",
				"8:30","9:30","13:30","14:30","15:30","16:30","17:30","18:30","19:30","20:30",
				"21:30","22:30"
		};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		khoitaocac();
		tabhost();
		batsukien();
		
	}
	private void tabhost() 
	{
	  tab=(TabHost)findViewById(android.R.id.tabhost);
	  tab.setup();
	  spec=tab.newTabSpec("t1");
	  spec.setContent(R.id.tab1);
	  spec.setIndicator("lich dat san");
	  tab.addTab(spec);
	  spec=tab.newTabSpec("t2");
	  spec.setContent(R.id.tab2);
	  spec.setIndicator("dang ki");
	  tab.addTab(spec);
	  tab.setCurrentTab(0);
	  tab.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
		public void onTabChanged(String tabId) {
			String s="tab tag "+tabId+" index ="+tab.getCurrentTab();
			Toast make=Toast.makeText(getApplicationContext(), s,Toast.LENGTH_LONG);
			make.show();
		}
	});
	}
  public void getinfor()
  {
	  Calendar cal=Calendar.getInstance();
	  SimpleDateFormat dft=null;
	  dft=new SimpleDateFormat("dd/mm/yyyy",Locale.getDefault());
	  String str=dft.format(cal);
	  dft=new SimpleDateFormat("hh:mm a", Locale.getDefault());
	  String str1=dft.format(cal);
  }
	private void batsukien() 
	{
	   list.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(ghiten.getText().toString().equals("")||ghiso.getText().toString().equals("")||m==0||n==0||k==0)
			{
				AlertDialog.Builder bluider=new AlertDialog.Builder(MainActivity.this);
				bluider.setTitle("Thieu thong tin");
				bluider.setMessage("Ban vui long dien du thong tin");
				bluider.setPositiveButton("Continue", new
						DialogInterface.OnClickListener() {
						public void
						onClick(DialogInterface dialog, int which) {
						
						 }
						 });
						 bluider.show();
				}
			else
			{
				System.out.println("toi muon biet"+m+":"+n+":"+k);
				AlertDialog.Builder bluider1=new AlertDialog.Builder(MainActivity.this);
				bluider1.setTitle("Kiem tra thong tin");
				bluider1.setMessage("Vui long kiem tra lai thong tin"+"\n"+
				"Ngày đặt sân:"+arg[hung.getSelectedItemPosition()]+"\n"+"Giờ đặt sân:"+arg1[khong.getSelectedItemPosition()]+"\n"+
				"Tên người đặt:"+ghiten.getText().toString()+"\n"+"Vị trí đặt:"+arg2[so.getSelectedItemPosition()]+"\n"+"Số điện thoại liên hệ:"+ghiso.getText().toString()
				);
				bluider1.setPositiveButton("YES", new
			    		DialogInterface.OnClickListener() {
							
							public void onClick(DialogInterface dialog, int which) {
								    int t=hung.getSelectedItemPosition()*100+khong.getSelectedItemPosition();
								    int h=so.getSelectedItemPosition();
								    kh=new khachhang(ghiten.getText().toString(),ghiso.getText().toString(),arg[hung.getSelectedItemPosition()],arg1[khong.getSelectedItemPosition()],arg2[so.getSelectedItemPosition()],t);
								    
								tongquat.add(kh);
								Collections.sort(tongquat);	
								listview.setAdapter(adapter);
								tab.setCurrentTab(0);
								hung.setId(0);
								khong.setId(0);
								so.setId(0);
								ghiten.setText("");
								ghiso.setText("");
							   }
						}
			    		);
				bluider1.setNegativeButton("NO", new
						DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								dialog.cancel();
								
							}
						}
				
			);
				bluider1.show();
			}
		}
	   });
	}
	private void khoitaocac()
	{	 
		hung=(Spinner)findViewById(R.id.spinner1);
		ArrayAdapter<String> arrayadapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arg);
		arrayadapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
		hung.setAdapter(arrayadapter);
		hung.setOnItemSelectedListener(new MyProcessEvent());

	khong=(Spinner)findViewById(R.id.spinner3);
	ArrayAdapter<String> arraydapter1=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, arg1);
	arraydapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
	khong.setAdapter(arraydapter1);
	khong.setOnItemSelectedListener(new Myinclick());
	ghiten=(EditText)findViewById(R.id.editten);
	ghiso=(EditText)findViewById(R.id.editphone);
	
	so=(Spinner)findViewById(R.id.spinner2);
	ArrayAdapter<String> arrayadapter2=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arg2);
	arrayadapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
	so.setAdapter(arrayadapter2);
	so.setOnItemSelectedListener(new Myinclick());
	list=(Button)findViewById(R.id.button1);
	tongquat=new ArrayList<khachhang>();
	sana1=new ArrayList<khachhang>();
	sana2=new ArrayList<khachhang>();
	sana3=new ArrayList<khachhang>();
	sanb1=new ArrayList<khachhang>();
	sanb2=new ArrayList<khachhang>();
	sanb3=new ArrayList<khachhang>();
	sanc1=new ArrayList<khachhang>();
	sanc2=new ArrayList<khachhang>();
	listview=(ListView)findViewById(R.id.listview1);
	adapter=new khachhangadapter(this,R.layout.layout_item_custom,tongquat);
}
	private class MyProcessEvent implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int position,
				long id) {
		     m=position;

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub

		}
    private class myonclick implements OnClickListener
    {

		@Override
		public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.txtgio:
			toigio();
		    break;
		case R.id.txtday:
			toingay();
			break;
		}
		}
    	
    }
    private class Myinclick implements OnItemSelectedListener
    {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
			// TODO Auto-generated method stub
			
		}
    	
    }
    
	}
	
	
	
}