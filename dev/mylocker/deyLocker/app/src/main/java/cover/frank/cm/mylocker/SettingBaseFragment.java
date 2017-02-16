package cover.frank.cm.mylocker;


import android.app.Fragment;

/**
 * Created by George on 2017/2/13.
 */

public class SettingBaseFragment extends Fragment {

    private boolean mIsAdded;

    public SettingBaseFragment() {
        mIsAdded = false;
    }

    public void setAdded(boolean b) {
        mIsAdded = b;
    }

    public boolean getAdded() {
        return mIsAdded;
    }

    public void onCallBack() {

    }

    public void setFragmentStatusListener(IFragmentStatusListener listener) {

    }


}
