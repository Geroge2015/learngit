package cover.frank.cm.mylocker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by George on 2017/2/10.
 *
 */

public class SettingsTabActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        safeInflate();
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
        switch (v.getId()) {
            case R.id.tab_style_wallpaper:

                break;
            case R.id.tab_protect:
                break;
            case R.id.tab_message:
                break;
            case R.id.tab_options:
                break;
        }

    }
}
