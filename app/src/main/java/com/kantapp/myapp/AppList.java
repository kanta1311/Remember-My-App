package com.kantapp.myapp;

import android.graphics.drawable.Drawable;

/**
 * Created by Manju on 10/8/2017.
 */

class AppList {
    private String name;
    private String packageName;
    Drawable icon;

    public AppList(String name, String packageName, Drawable icon) {
        this.name = name;
        this.packageName = packageName;
        this.icon = icon;
    }

    public String getPackageName() {

        return packageName;
    }



    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }
}
