package cover.frank.cm.mylocker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

/**
 * Created by George on 2017/2/10.
 *
 */

public class SettingsTabActivity extends AppCompatActivity implements View.OnClickListener {

    private SettingBaseFragment mThemeTabFragment;
    private SettingBaseFragment mSecurityTabFragment;
    private SettingBaseFragment mNotificationTabFragment;
    private SettingBaseFragment mMoreTabFragment;

    private static final String TAG_TAB_THEME = "tag_tab_theme";
    private static final String TAG_TAB_SECURITY = "tag_tab_security";
    private static final String TAG_TAB_NOTIFICATION = "tag_tab_notification";
    private static final String TAB_TAB_MORE_OPTIONS = "tab_tab_more_options";


    private RadioButton mTabTheme;
    private RadioButton mTabSecurity;
    private RadioButton mTabNotification;
    private RadioButton mTabMoreOptions;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        safeInflate();
        setupView();
    }

    private void setupView() {
        FragmentManager fm = getSupportFragmentManager();

        mThemeTabFragment = (ThemeTabFragment)fm.findFragmentByTag(TAG_TAB_THEME);
        if (null == mThemeTabFragment) {
            mThemeTabFragment = new ThemeTabFragment();
        }
        mSecurityTabFragment = (SecurityTabFragment) fm.findFragmentByTag(TAG_TAB_SECURITY);
        if (null == mSecurityTabFragment) {
            mSecurityTabFragment = new SecurityTabFragment();
        }
        // todo   there are two fragment undo.
        setupTabButtons();
    }

    private void setupTabButtons() {

        mTabSecurity = (RadioButton) this.findViewById(R.id.tab_protect);
        mTabSecurity.setOnClickListener(this);

    }

    private void safeInflate() {
        try {
            setContentView(R.layout.activity_settings_tab);
        } catch (Throwable e) {
            Process.killProcess(Process.myPid());
        }

    }

    public static void startFromLaunch(Context context, boolean newEnabled) {
        Intent intent = new Intent(context, SettingsTabActivity.class);
        intent.putExtra(KSettingConstants.INTENT_EXTRA_START_FROM_LAUNCH, true);
        if (newEnabled) {
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        boolean result = false;
        switch (v.getId()) {
            case R.id.tab_style_wallpaper:
                result = switchFragment(mThemeTabFragment, TAG_TAB_THEME);
                break;
            case R.id.tab_protect:
                result = switchFragment(mSecurityTabFragment, TAG_TAB_SECURITY);

                break;
            case R.id.tab_message:
                break;
            case R.id.tab_options:
                break;
        }

    }

    private boolean switchFragment(SettingBaseFragment fragment, String tag) {
        try {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            if (fragment.getAdded()) {

            } else {
                transaction.add(R.id.fragment_layout, fragment, tag);
                fragment.setAdded(true);
                transaction.show(fragment);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
