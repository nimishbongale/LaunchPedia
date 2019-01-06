package com.example.nimishbongale.list;

public class Product {
    private String title;
    private String shortdesc;
    private String rating;
    private String t;
    private int image;
    private String longdesc;
    private int secimage;
    private String locat;
    private String url;

    public Product(String title, String shortdesc, String rating, String t,int image,String ld,int secimg,String locat,String url) {
        this.title = title;
        this.shortdesc = shortdesc;
        this.rating = rating;
        this.t = t;
        this.image = image;
        this.longdesc=ld;
        this.secimage=secimg;
        this.locat=locat;
        this.url=url;
    }

    public String getTitle() {
        return title;
    }


    public String getShortdesc() {
        return shortdesc;
    }

    public String getRating() {
        return rating;
    }

    public String gett() {
        return t;
    }

    public int getImage() {
        return image;
    }

    public String getLongdesc(){ return longdesc;}

    public int getSecimage(){ return secimage;}

    public String getLocat() {
        return locat;
    }

    public String getUrl() {
        return url;
    }
}

