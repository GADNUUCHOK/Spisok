package com.example.work_gadnuuk.spisok;

import android.support.v4.app.Fragment;

public class SpisokListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SpisokListFragment();
    }
}
