package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jamesonli.paymentdemo.R;

/**
 * Created by james on 1/15/16.
 */
public class ApprovedFragment extends Fragment {

    public static ApprovedFragment getInstance() {
        return new ApprovedFragment();
    }

    public ApprovedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_approved, container, false);
    }
}
