package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamesonli.paymentdemo.R;

/**
 * Created by james on 1/15/16.
 */
public class DetailsFragment extends Fragment {

    public static DetailsFragment getInstance() {
        return new DetailsFragment();
    }

    public DetailsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView confirmButtonLabel = (TextView) view.findViewById(R.id.button_rounded_locked_label);
        confirmButtonLabel.setText(R.string.details_confirm_button_label);
    }
}
