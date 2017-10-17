package com.kantapp.myapp;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView userInstalledApps = (ListView)findViewById(R.id.installed_app_list);

        List<AppList> installedApps = getInstalledApps();
        AppAdapter installedAppAdapter = new AppAdapter(MainActivity.this, installedApps);
        userInstalledApps.setAdapter(installedAppAdapter);
    }

    private List<AppList> getInstalledApps() {
        List<AppList> res = new ArrayList<AppList>();
        List<PackageInfo> packs=getPackageManager().getInstalledPackages(0);
        for(int i=0;i<packs.size();i++)
        {
            PackageInfo p=packs.get(i);
            if((isSystemPackage(p)==false))
            {
                SimpleDateFormat date=new SimpleDateFormat("[dd-MM-yyyy - HH:mm:ss]");
                String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                String packagename = p.packageName+" "+p.versionName+" "+date.format(new Date(p.firstInstallTime));

                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                res.add(new AppList(appName,packagename, icon));
            }
        }
        return res;
    }
    private boolean isSystemPackage(PackageInfo pkgInfo)
    {
        return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true : false;
    }
}
