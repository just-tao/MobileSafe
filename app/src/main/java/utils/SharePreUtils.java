package utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by JT on 2016/7/5.
 */
public class SharePreUtils {
    private static SharedPreferences sharedPreferences;
    public static void putBoolean(Context context,String key,boolean isChecked){
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,isChecked);
        editor.commit();
    }
    public static boolean getBoolean(Context context, String key,boolean isChecked){
        if(sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(key,Context.MODE_PRIVATE);
        }
        return sharedPreferences.getBoolean(key,isChecked);
    }
}
