package com.ixuea.courses.kaimeitu.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    /**
     * 唯一的Toast
     */
    private static Toast toast = null;

    public static void shortToast(Context context, String message){
        showToast(context,message,Toast.LENGTH_SHORT);
    }
    public static void showToast(Context context,int resId){
        showToast(context,context.getResources().getString(resId),Toast.LENGTH_SHORT);
    }
    public static void showToast(Context context,String message,int time){
        if(toast!=null){
        }else{
            toast = Toast.makeText(context.getApplicationContext(),message,time);
        }
        toast.setText(message);
        toast.show();
    }

}
