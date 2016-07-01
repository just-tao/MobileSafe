package activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import just_tao.mobilesafe.R;

/**
 * Created by JT on 2016/6/29.
 */
public class SplashActivity extends Activity{
    public final static String DebugTag = "DebugInfo";

    private TextView version;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        version = (TextView)findViewById(R.id.app_version);
        version.setText("Version:" + getVersion());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent startHome = new Intent(SplashActivity.this, HomeActivity.class);
                SplashActivity.this.startActivity(startHome);
                SplashActivity.this.finish();
            }
        }, 1000);

    }
    private String getVersion(){
        PackageManager pm = getPackageManager();
        try{
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(),0);
            String versionName = packageInfo.versionName;
            Log.d(DebugTag,"versionName = "+versionName);
            return versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return "";
        }
    }
    private int getVersionCode(){
        PackageManager pm = getPackageManager();
        try{
            PackageInfo packageInfo = pm.getPackageInfo(getPackageName(),0);
            int versionName = packageInfo.versionCode;
            Log.d(DebugTag,"versionName = "+versionName);
            return versionName;
        }catch (PackageManager.NameNotFoundException e){
            e.printStackTrace();
            return 0;
        }
    }
}
