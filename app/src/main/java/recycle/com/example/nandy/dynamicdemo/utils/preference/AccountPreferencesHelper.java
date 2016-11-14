package recycle.com.example.nandy.dynamicdemo.utils.preference;

/**
 * Created by wyf
 */
public class AccountPreferencesHelper {
    private static final String PREFERENCES_FILE_NAME = PreferencesHelper.getFullPreferenceFileName("user_account");
    private static PreferencesHelper sPreferencesHelper;

    private static PreferencesHelper getPreferencesHelper() {
        if (sPreferencesHelper == null) {
            sPreferencesHelper = PreferencesHelper.newInstance(PREFERENCES_FILE_NAME);
        }
        return sPreferencesHelper;
    }
}
