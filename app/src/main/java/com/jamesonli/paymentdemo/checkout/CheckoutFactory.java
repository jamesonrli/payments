package com.jamesonli.paymentdemo.checkout;

import android.app.Fragment;

/**
 * Created by james on 1/16/16.
 */
public class CheckoutFactory {

    public enum CheckoutState {
        SIGNUP,
        VERIFY,
        DETAILS,
        APPROVED
    }

    public static Fragment getNextCheckoutFragment(CheckoutInteraction interaction, CheckoutState currentState) {
        switch (currentState) {
            case SIGNUP:
                return VerificationFragment.getInstance(interaction);
            case VERIFY:
                return DetailsFragment.getInstance(interaction);
            case DETAILS:
                return ApprovedFragment.getInstance(interaction);
            case APPROVED:
            default:
                return SignUpFragment.getInstance(interaction);
        }
    }
}
