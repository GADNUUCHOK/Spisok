package com.example.work_gadnuuk.spisok;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SpisokActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new SpisokFragment();
    }
}
