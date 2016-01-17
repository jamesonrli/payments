package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jamesonli.paymentdemo.R;
import com.jamesonli.paymentdemo.checkout.loan.LoanOptionsAdapter;

/**
 * Created by james on 1/15/16.
 */
public class DetailsFragment extends Fragment {

    private CheckoutInteraction interaction;
    private CheckoutData checkoutData;
    private LoanOptionsAdapter loanOptionAdapter;

    public static DetailsFragment getInstance(CheckoutInteraction interaction) {
        DetailsFragment fragment = new DetailsFragment();
        fragment.interaction = interaction;
        return fragment;
    }

    public DetailsFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        checkoutData = interaction.getCheckoutData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView confirmButtonLabel = (TextView) view.findViewById(R.id.button_rounded_locked_label);
        confirmButtonLabel.setText(R.string.details_confirm_button_label);

        View confirmButton = view.findViewById(R.id.button_submit);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interaction.confirmationButtonHandler(CheckoutFactory.CheckoutState.DETAILS);
            }
        });

        setCheckoutData(view);
    }

    private void setCheckoutData(View view) {
        if(checkoutData == null) { return; }

        // headline
        TextView headline = (TextView) view.findViewById(R.id.details_headline);
        headline.setText(String.format(getString(R.string.details_approved_text),
                checkoutData.getApprovedAmount()));

        // apr
        TextView interestView = (TextView) view.findViewById(R.id.details_interest_text);
        interestView.setText(String.format(getString(R.string.details_loan_interest_text),
                checkoutData.getAPR(),
                checkoutData.getInterestAmount()));

        // total payment
        TextView totalView = (TextView) view.findViewById(R.id.details_total_payments_text);
        totalView.setText(String.format(getString(R.string.details_loan_payments_text),
                checkoutData.getPaymentTotal()));

        // tos
        TextView tosView = (TextView) view.findViewById(R.id.details_tos_text);
        tosView.setText(String.format(getString(R.string.details_loan_tos_text),
                checkoutData.getFirstDueDate()));

        // loan options
        RecyclerView loanOptionsView = (RecyclerView) view.findViewById(R.id.details_loan_options_list);
        loanOptionsView.setLayoutManager(new LinearLayoutManager(getActivity()));
        loanOptionAdapter = new LoanOptionsAdapter(getActivity(), checkoutData.getLoanOptions());
        loanOptionsView.setAdapter(loanOptionAdapter);
    }

}
