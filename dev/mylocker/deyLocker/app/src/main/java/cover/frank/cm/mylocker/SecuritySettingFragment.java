package cover.frank.cm.mylocker;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import android.view.View;


/**
 * Created by George on 2017/2/13.
 *
 */

public class SecuritySettingFragment extends PreferenceFragment{

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_fragment_security);

    }
}
