package com.rizzhivaykini.nurbiuti.Entities;

import android.os.Bundle;

/**
 * Created by GrkRise on 14.07.2016.
 */

public class Bubble {

    protected String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    protected int id;





    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Bundle toBundle(){
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putInt("id", id);
        return bundle;
    }

    public static Bubble fromBundle(Bundle bundle){
        Bubble bubble = new Bubble();
        bubble.setTitle(bundle.getString("title"));
        bubble.setId(bundle.getInt("id"));
        return bubble;
    }




}
