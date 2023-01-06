package com.newsapp.utils;

public class PostExcerpt {
    public static String getExcerpt(String s,int length){
        String excerpt=null;
        excerpt=s.substring(0,length)+" [...]";
        return excerpt;
    }
}
