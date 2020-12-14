package com.example.a123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;

public class Transform {
    public static final String APP_PREFERENCES = "mysettings";
    public static Boolean StringNoNull(String string)
    {
        if(string==null)
            return false;
        else return string.length() !=0;
    }
    public static  int parseIntOfDefault(String whatParse, int defaultValue)
    {
        int parse;
        try{
            parse = Integer.parseInt(whatParse);
        }
        catch (Exception NumberFormatException)
        {
            parse = defaultValue;
        }
        return parse;
    }

    public static void Vibrate(Context context)
    {
        long mills =1000L;
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        if(vibrator.hasVibrator()){
            vibrator.vibrate(mills);
        }
    }

    public static int parseIntOrDefault(String toString, int i) {
        return 0;
    }
    public static void SaveUser(SharedPreferences sp, String login, String password)
    {
        SharedPreferences.Editor e = sp.edit();
        e.putString(LOGIN,login);
        e.putString(PASSWORD,password);
        e.apply();

    }
    private void goNext(String profileId, String login, String password){
        UserStaticInfo.profileId = profileId;
        SaveUser(getSharedPreferences(APP_PREFERENCES,Context.MODE_PRIVATE),login, password);
    }

    private String getPassword() {
        return null;
    }

    private String getLogin() {
        return null;
    }

    private SharedPreferences getSharedPreferences(String appPreferences, int modePrivate) {
        return null;
    }
    public static Bitmap getRoundedMapBitmap(Bitmap bitmap) {
        int iconSize = 100;
        Bitmap output = Bitmap.createScaledBitmap(bitmap, iconSize, iconSize, false);
        return getRoundedCornerCubeBitmap(output,iconSize);}

    private static Bitmap getRoundedCornerCubeBitmap(Bitmap output, int iconSize) {
        return null;
    }


}