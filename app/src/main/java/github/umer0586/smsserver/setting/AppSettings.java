package github.umer0586.smsserver.setting;

import android.content.Context;
import android.content.SharedPreferences;

import github.umer0586.smsserver.R;

/*
 * Since we can't save context in static field therefore client must create new object of this
 * class to gain access to shared preferences. Multiple objects of AppSettings point to same shared preferences
 * */

public class AppSettings {

    // don't save context in static field its a memory leak
    private Context context;
    private SharedPreferences sharedPreferences;

    public AppSettings(Context context)
    {
        this.context = context;
        sharedPreferences = context.getApplicationContext().getSharedPreferences(context.getString(R.string.shared_pref_file), Context.MODE_PRIVATE);
    }

    public int getPortNo()
    {
        return sharedPreferences.getInt(context.getString(R.string.pref_key_port_no), 8080);
    }

    public boolean isSecureConnectionEnable()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_key_secure_connection), false);
    }

    public boolean isPasswordEnable()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_key_password_switch), false);
    }

    public String getPassword()
    {
        return sharedPreferences.getString(context.getString(R.string.pref_key_password), null);
    }

    public void savePassword(String password)
    {
        sharedPreferences.edit()
                .putString(context.getString(R.string.pref_key_password),password)
                .apply();
    }

    public void savePortNo(int portNo)
    {
        sharedPreferences.edit()
                .putInt(context.getString(R.string.pref_key_port_no),portNo)
                .apply();
    }

    public void secureConnection(boolean state)
    {
        saveBoolean(context.getString(R.string.pref_key_secure_connection),state);
    }

    public void enablePassword(boolean state)
    {
        saveBoolean(context.getString(R.string.pref_key_password_switch),state);
    }

    public void enableHotspotOption(boolean state)
    {
        saveBoolean(context.getString(R.string.pref_key_hotspot),state);
    }
    private void saveBoolean(String key, boolean value){
        sharedPreferences.edit().putBoolean(key,value).apply();
    }
    public boolean isHotspotOptionEnabled()
    {
        return sharedPreferences.getBoolean(context.getString(R.string.pref_key_hotspot), false);
    }

}
