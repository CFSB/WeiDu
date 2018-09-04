package com.bw.movie.utils;

/**
 * @author Codes-小生
 * @create 2018/8/10 15:02
 */

import android.content.Context;
import android.content.SharedPreferences;

import com.bw.movie.ui.member.act_login.bean.LoginBean;

/**
 *
 * 注意要点：1、需要在application中调用init()，
 *           2、需要在清单文件中声名
 *           3、需要在每个get和put方法中先调用throwInit()
 *           4、创建一个Constants类，里面定义一些静态final常量，存放文件名或者key值(脑袋智障了忘掉咋整?)
 * @author admin
 * @version 1.0
 * @create 2018/6/28
 */
public class SharedPreferencesUtils {

    /**
     * 存放的文件和key
     */
    //存放登录状态LoginState对象的文件
    public static final String UserInfoFileName = "userInfo";
    //key
    public static final String UserInfoKey = "userInfoKey";


    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    private static void throwInit() {
        if (mContext == null) {
            throw new NullPointerException("在使用该方法前，需要init()方法，推荐init()放在application里");
        }
    }
    //清空sp内容
    public static void clear(String fileName) {
        SharedPreferences sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    public static boolean putBoolean(String fileName,String key,boolean value) {
        throwInit();
        SharedPreferences sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.edit().putBoolean(key,value).commit();
    }
    public static boolean getBoolean(String fileName,String key,boolean defaultValue) {
        throwInit();
        SharedPreferences sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defaultValue);
    }
    public static boolean putString(String fileName,String key,String value) {
        throwInit();
        SharedPreferences sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.edit().putString(key,value).commit();
    }
    public static String getString(String fileName,String key,String defaultValue) {
        throwInit();
        SharedPreferences sp = mContext.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return sp.getString(key, defaultValue);
    }

}

