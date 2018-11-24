package com.shalan.newsfeed.utils;

import android.content.Context;
import android.net.ConnectivityManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static boolean checkConnectivity(Context context){
        ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return mConnectivityManager.getActiveNetworkInfo() != null;
    }

    public static String getProperDate(String date){
        String displayDate = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date returnedDate = simpleDateFormat.parse(date.split("T")[0]);
            SimpleDateFormat requiredFormat = new SimpleDateFormat("MMMM dd, yyyy");
            displayDate = requiredFormat.format(returnedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return displayDate;
    }
}
