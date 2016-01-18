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
 *
 * Allow users to SignUp for a new account
 */
public class SignUpFragment extends Fragment {

    private CheckoutInteraction interaction;

    public static SignUpFragment getInstance(CheckoutInteraction interaction) {
        SignUpFragment fragment = new SignUpFragment();
        fragment.interaction = interaction;

        return fragment;
    }

    public SignUpFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_signup, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // confirm button text
        TextView confirmButtonLabel = (TextView) view.findViewById(R.id.button_rounded_locked_label);
        confirmButtonLabel.setText(R.string.signup_label_confirm_button);

        // confirm button
        View confirmButton = view.findViewById(R.id.button_submit);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction.confirmationButtonHandler(CheckoutFactory.CheckoutState.SIGNUP);
            }
        });
    }
}
