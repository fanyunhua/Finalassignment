package com.fanyuhua.finalassignment.util.util;

public class Cm {
    int im;
    String price;
    String name;
    int count;
    public Cm(int im,String name,String price,int count )
    {
        this.im = im;
        this.price =price;
        this.name = name;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIm() {
        return im;
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIm(int im) {
        this.im = im;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
