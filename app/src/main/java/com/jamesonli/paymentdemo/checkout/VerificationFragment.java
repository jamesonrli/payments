package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamesonli.paymentdemo.R;
import org.w3c.dom.Text;

/**
 * Created by james on 1/15/16.
 */
public class VerificationFragment extends Fragment {

    private CheckoutInteraction interaction;
    private CheckoutData checkoutData;

    public static VerificationFragment getInstance(CheckoutInteraction interaction) {
        VerificationFragment fragment =  new VerificationFragment();
        fragment.interaction = interaction;
        return fragment;
    }

    public VerificationFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkoutData = interaction.getCheckoutData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_verify, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView confirmButtonLabel = (TextView) view.findViewById(R.id.button_rounded_locked_label);
        confirmButtonLabel.setText(R.string.verify_button_label);

        View confirmButton = view.findViewById(R.id.button_submit);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction.confirmationButtonHandler(CheckoutFactory.CheckoutState.VERIFY);
            }
        });

        if(checkoutData == null) { return; }
        TextView verifySubline = (TextView) view.findViewById(R.id.verify_subline);
        verifySubline.setText(String.format(getString(R.string.verify_message), checkoutData.getPhoneNumber()));

    }
}
