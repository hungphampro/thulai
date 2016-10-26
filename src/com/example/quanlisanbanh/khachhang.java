package com.example.quanlisanbanh;

public class khachhang implements Comparable{
    private String tenkh;
    private String sdt;
    private String ngay;
    private String gio;
    private String vtds;
    private int gtngaydat;
    public khachhang(String tenkh,String sdt,String ngay,String gio,String vtds,int gtngaydat)
    {
    	this.tenkh=tenkh;
    	this.sdt=sdt;
    	this.ngay=ngay;
    	this.gio=gio;
    	this.vtds=vtds;
    	this.gtngaydat=gtngaydat;
    	
    }
    public khachhang()
    {
    	
    }
    public void settenkh(String ten)
    {
    	this.tenkh=ten;
    }
    public String getten()
    {
    	return tenkh;
    }
    public void setsdt(String sdt)
    {
    	this.sdt=sdt;
    }
    public String getsdt()
    {
    	return sdt;
    }
    public String getvtds()
    {
    	return vtds;
    }
    public void setvtds(String vtds)
    {
    	this.vtds=vtds;
    }
    public void setngay(String ngay)
    {
        this.ngay=ngay;	
    }
    public String getngay()
    {
    	return ngay;
    }
    public void setgio(String gio)
    {
    	this.gio=gio;
    }
    public String getgio()
    {
    	return gio;
    }
    public void setngay(int n)
    {
    	this.gtngaydat=n;
    }
    public int getgtngay()
    {
    	return gtngaydat;
    }
  
	@Override
	public int compareTo(Object another) {
		khachhang second=(khachhang)another;
		return(int)this.getgtngay()-second.gtngaydat;
	}
}
