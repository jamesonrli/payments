package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jamesonli.paymentdemo.R;

/**
 * Created by james on 1/15/16.
 *
 * Fragment displayed after the user completes the loan process
 */
public class ApprovedFragment extends Fragment {

    private CheckoutInteraction interaction;

    public static ApprovedFragment getInstance(CheckoutInteraction interaction) {
        ApprovedFragment fragment = new ApprovedFragment();
        fragment.interaction = interaction;
        return fragment;
    }

    public ApprovedFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_approved, container, false);
    }
}
