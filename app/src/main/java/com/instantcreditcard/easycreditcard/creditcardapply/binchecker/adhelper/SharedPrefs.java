package com.instantcreditcard.easycreditcard.creditcardapply.binchecker.adhelper;

import android.content.Context;
import android.content.SharedPreferences;

import org.json.JSONArray;
import org.json.JSONException;

//SharedPreferences manager class
public class SharedPrefs {


    //TODO FGOR SCBRRIOPT
    public static String IS_NEED_TO_SHOW_RATE_DIALOG = "IS_NEED_TO_SHOW_RATE_DIALOG";
    //SharedPreferences file name
    private static String SHARED_PREFS_FILE_NAME = "beggar_suit_shared_prefs";
    public static final String IS_ADS_REMOVED = "is_ads_removed";
    // use for getting current device id
    public static final String DEVICE_ID="device_id";

    public static final String PREF_NIGHT_MODE = "night_mode";
    public static final String WA_TREE_URI = "wa_tree_uri";
    public static final String WB_TREE_URI = "wb_tree_uri";
    private static SharedPreferences mPreferences;


    private static SharedPreferences getInstance(Context context) {
        if (mPreferences == null) {
            mPreferences = context.getApplicationContext().getSharedPreferences("stat_data", 0);
        }
        return mPreferences;
    }


    public static void saveEncryptedKeyValue(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value+"==").commit();
    }
    public static String getEncryptedString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }
    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }
    public static boolean contain(Context context, String key) {
        return getPrefs(context).contains(key);
    }
    public static void clearPrefs(Context context) {
        String device_id = getString(context,DEVICE_ID);
        getPrefs(context).edit().clear().commit();
        save(context,DEVICE_ID,device_id);
    }


    public static void  saveArrayData(Context mContext, String key, JSONArray array) throws JSONException {
        StringBuilder sb=new StringBuilder();
        for (int i=0 ; i < array.length();i++) {
            sb.append(array.get(i)).append(",");
        }
        getPrefs(mContext).edit().putString(key,sb.toString()).commit();
    }

    public static String[] getArrayData(Context mContext,String key){
        getPrefs(mContext).getString(key,"");
        String[] separated = getPrefs(mContext).getString(key,"").split(",");
        return separated;
    }


    //Save Booleans
    public static void savePref(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).commit();
    }

    //Get Booleans
    public static boolean getBoolean(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }

    //Get Booleans if not found return a predefined default value
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPrefs(context).getBoolean(key, defaultValue);
    }

    //Strings
    public static void save(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }

    //Save Booleans
    public static void save2(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).commit();
    }

    //Get Booleans
    public static boolean getBoolean2(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }

    public static String getString(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }

    //Integers
    public static void save(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getPrefs(context).getInt(key, defaultValue);
    }

    //Floats
    public static void save(Context context, String key, float value) {
        getPrefs(context).edit().putFloat(key, value).commit();
    }

    public static float getFloat(Context context, String key) {
        return getPrefs(context).getFloat(key, 0);
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        return getPrefs(context).getFloat(key, defaultValue);
    }

    //Longs
    public static void save(Context context, String key, long value) {
        getPrefs(context).edit().putLong(key, value).commit();
    }

    public static long getLong(Context context, String key) {
        return getPrefs(context).getLong(key, 0);
    }

    public static long getLong(Context context, String key, long defaultValue) {
        return getPrefs(context).getLong(key, defaultValue);
    }

    public static boolean removeKey(Context context, String key)
    {
        getPrefs(context).edit().remove(key).commit();
        return false;
    }


    public static void setWATree(Context context, String str) {
        getInstance(context).edit().putString(WA_TREE_URI, str).apply();
    }

    public static String getWATree(Context context) {
        return getInstance(context).getString(WA_TREE_URI, "");
    }

    public static void setWBTree(Context context, String str) {
        getInstance(context).edit().putString(WB_TREE_URI, str).apply();
    }

    public static String getWBTree(Context context) {
        return getInstance(context).getString(WB_TREE_URI, "");
    }

    public static void setWAImgTree(Context context, String str) {
        getInstance(context).edit().putString("wa_img_tree_uri", str).apply();
    }

    public static String getWAImgTree(Context context) {
        return getInstance(context).getString("wa_img_tree_uri", "");
    }

    public static void setWAImgSendTree(Context context, String str) {
        getInstance(context).edit().putString("wa_img_send_tree_uri", str).apply();
    }

    public static String getWAImgSendTree(Context context) {
        return getInstance(context).getString("wa_img_send_tree_uri", "");
    }

    public static void setWAVideoTree(Context context, String str) {
        getInstance(context).edit().putString("wa_video_tree_uri", str).apply();
    }

    public static String getWAVideoTree(Context context) {
        return getInstance(context).getString("wa_video_tree_uri", "");
    }

    public static void setWAVideoSendTree(Context context, String str) {
        getInstance(context).edit().putString("wa_video_send_tree_uri", str).apply();
    }

    public static String getWAVideoSendTree(Context context) {
        return getInstance(context).getString("wa_video_send_tree_uri", "");
    }

    public static void setWADocTree(Context context, String str) {
        getInstance(context).edit().putString("wa_doc_tree_uri", str).apply();
    }

    public static String getWADocTree(Context context) {
        return getInstance(context).getString("wa_doc_tree_uri", "");
    }

    public static void setWADocSendTree(Context context, String str) {
        getInstance(context).edit().putString("wa_doc_send_tree_uri", str).apply();
    }

    public static String getWADocSendTree(Context context) {
        return getInstance(context).getString("wa_doc_send_tree_uri", "");
    }

    public static void setWAAudioTree(Context context, String str) {
        getInstance(context).edit().putString("wa_audio_tree_uri", str).apply();
    }

    public static String getWAAudioTree(Context context) {
        return getInstance(context).getString("wa_audio_tree_uri", "");
    }

    public static void setWAAudioSendTree(Context context, String str) {
        getInstance(context).edit().putString("wa_audio_send_tree_uri", str).apply();
    }

    public static String getWAAudioSendTree(Context context) {
        return getInstance(context).getString("wa_audio_send_tree_uri", "");
    }

    public static void setWAStickerTree(Context context, String str) {
        getInstance(context).edit().putString("wa_sticker_tree_uri", str).apply();
    }

    public static String getWAStickerTree(Context context) {
        return getInstance(context).getString("wa_sticker_tree_uri", "");
    }

    public static void setWAGifTree(Context context, String str) {
        getInstance(context).edit().putString("wa_Gif_tree_uri", str).apply();
    }

    public static String getWAGifTree(Context context) {
        return getInstance(context).getString("wa_Gif_tree_uri", "");
    }

    public static void setWAGifSendTree(Context context, String str) {
        getInstance(context).edit().putString("wa_Gif_send_tree_uri", str).apply();
    }

    public static String getWAGifSendTree(Context context) {
        return getInstance(context).getString("wa_Gif_send_tree_uri", "");
    }

    public static void setWAWallTree(Context context, String str) {
        getInstance(context).edit().putString("wa_wall_tree_uri", str).apply();
    }

    public static String getWAWallTree(Context context) {
        return getInstance(context).getString("wa_wall_tree_uri", "");
    }

    public static void setWBImgTree(Context context, String str) {
        getInstance(context).edit().putString("wb_img_tree_uri", str).apply();
    }

    public static String getWBImgTree(Context context) {
        return getInstance(context).getString("wb_img_tree_uri", "");
    }

    public static void setWBImgSendTree(Context context, String str) {
        getInstance(context).edit().putString("wb_img_send_tree_uri", str).apply();
    }

    public static String getWBImgSendTree(Context context) {
        return getInstance(context).getString("wb_img_send_tree_uri", "");
    }

    public static void setWBVideoTree(Context context, String str) {
        getInstance(context).edit().putString("wb_video_tree_uri", str).apply();
    }

    public static String getWBVideoTree(Context context) {
        return getInstance(context).getString("wb_video_tree_uri", "");
    }

    public static void setWBVideoSendTree(Context context, String str) {
        getInstance(context).edit().putString("wb_video_send_tree_uri", str).apply();
    }

    public static String getWBVideoSendTree(Context context) {
        return getInstance(context).getString("wb_video_send_tree_uri", "");
    }

    public static void setWBDocTree(Context context, String str) {
        getInstance(context).edit().putString("wb_doc_tree_uri", str).apply();
    }

    public static String getWBDocTree(Context context) {
        return getInstance(context).getString("wb_doc_tree_uri", "");
    }

    public static void setWBDocSendTree(Context context, String str) {
        getInstance(context).edit().putString("wb_doc_send_tree_uri", str).apply();
    }

    public static String getWBDocSendTree(Context context) {
        return getInstance(context).getString("wb_doc_send_tree_uri", "");
    }

    public static void setWBAudioTree(Context context, String str) {
        getInstance(context).edit().putString("wb_audio_tree_uri", str).apply();
    }

    public static String getWBAudioTree(Context context) {
        return getInstance(context).getString("wb_audio_tree_uri", "");
    }

    public static void setWBAudioSendTree(Context context, String str) {
        getInstance(context).edit().putString("wb_audio_send_tree_uri", str).apply();
    }

    public static String getWBAudioSendTree(Context context) {
        return getInstance(context).getString("wb_audio_send_tree_uri", "");
    }

    public static void setWBStickerTree(Context context, String str) {
        getInstance(context).edit().putString("wb_sticker_tree_uri", str).apply();
    }

    public static String getWBStickerTree(Context context) {
        return getInstance(context).getString("wb_sticker_tree_uri", "");
    }

    public static void setWBGifTree(Context context, String str) {
        getInstance(context).edit().putString("wb_Gif_tree_uri", str).apply();
    }

    public static String getWBGifTree(Context context) {
        return getInstance(context).getString("wb_Gif_tree_uri", "");
    }

    public static void setWBGifSendTree(Context context, String str) {
        getInstance(context).edit().putString("wb_Gif_send_tree_uri", str).apply();
    }

    public static String getWBGifSendTree(Context context) {
        return getInstance(context).getString("wb_Gif_send_tree_uri", "");
    }

    public static void setWBWallTree(Context context, String str) {
        getInstance(context).edit().putString("wb_wall_tree_uri", str).apply();
    }

    public static String getWBWallTree(Context context) {
        return getInstance(context).getString("wb_wall_tree_uri", "");
    }


}