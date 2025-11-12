package com.example.gettingstartedapp.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Context context;

    private static final String PREF_NAME = "AppSession";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";

    public SessionManager(Context context) {
        this.context = context;
        prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void saveLogin(String username) {
        //TODO: no 1
        editor.putString(KEY_USERNAME, username);
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        editor.apply();
    }

    public boolean isLoggedIn() {
        //TODO: no 1
        prefs.getBoolean(KEY_IS_LOGGED_IN, false);
        return true;
    }

    public String getUsername() {
        //TODO: no 1
        prefs.getString(KEY_USERNAME, "");
        return "";
    }

    public void logout() {
        //TODO: no 1
        editor.clear();
        editor.apply();
    }
}