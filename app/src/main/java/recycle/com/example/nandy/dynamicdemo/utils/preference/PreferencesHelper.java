package recycle.com.example.nandy.dynamicdemo.utils.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * @author yufeng.wu
 */
public class PreferencesHelper {

    private static final String PREFERENCES_NAME_PREFIX = "pref_nfs_";
    private final String mPreferencesFileName;
    private static Context sContext;

    public static void init(Context context) {
        sContext = context.getApplicationContext();
    }

    public static Context getContext() {
        return sContext;
    }

    public static String getFullPreferenceFileName(String name) {
        return PREFERENCES_NAME_PREFIX + name;
    }

    public static PreferencesHelper newInstance(String name) {
        return new PreferencesHelper(name);
    }

    public PreferencesHelper(String name) {
        mPreferencesFileName = name;
    }

    private SharedPreferences getPreferences() {
        return sContext.getSharedPreferences(mPreferencesFileName, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }

    public void putInt(String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    public int getInt(String key, int defValue) {
        return getPreferences().getInt(key, defValue);
    }

    public void putString(String key, String value) {
        getEditor().putString(key, value).apply();
    }

    public String getString(String key, String defValue) {
        return getPreferences().getString(key, defValue);
    }

    public void putBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return getPreferences().getBoolean(key, defValue);
    }

    public void putLong(String key, long value) {
        getEditor().putLong(key, value).apply();
    }

    public long getLong(String key, long defValue) {
        return getPreferences().getLong(key, defValue);
    }

    public boolean contains(String key) {
        return getPreferences().contains(key);
    }

    public void remove(String key) {
        getEditor().remove(key).apply();
    }

}
