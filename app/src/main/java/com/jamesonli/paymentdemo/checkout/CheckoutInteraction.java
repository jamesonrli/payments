package com.jamesonli.paymentdemo.checkout;

/**
 * Created by james on 1/16/16.
 *
 * Allow fragments used in the checkout flow to communicate with the parent CheckoutActivity.
 */
public interface CheckoutInteraction {
    void confirmationButtonHandler(CheckoutFactory.CheckoutState state);
    CheckoutData getCheckoutData();
}
