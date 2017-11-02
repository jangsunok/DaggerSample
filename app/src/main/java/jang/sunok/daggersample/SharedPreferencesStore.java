package jang.sunok.daggersample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jangsunok on 2017. 11. 02.
 */

public class SharedPreferencesStore {


    private SharedPreferences sharedPref;

    public SharedPreferencesStore(Context context) {
        sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
    }


    public int getIntValue(String key, int defaultValue) {
        return sharedPref.getInt(key, defaultValue);
    }


    public void setIntValue(String key, int value) {
        SharedPreferences.Editor spEditor = sharedPref.edit();
        spEditor.putInt(key, value);
        spEditor.apply();
    }


    public boolean getBooleanValue(String key, boolean defaultValue) {
        return sharedPref.getBoolean(key, defaultValue);
    }


    public void setBooleanValue(String key, boolean value) {
        SharedPreferences.Editor spEditor = sharedPref.edit();
        spEditor.putBoolean(key, value);
        spEditor.apply();
    }


    public String getStringValue(String key, String defaultValue) {
        return sharedPref.getString(key, defaultValue);
    }


    public void setStringValue(String key, String value) {
        SharedPreferences.Editor spEditor = sharedPref.edit();
        spEditor.putString(key, value);
        spEditor.apply();
    }

}