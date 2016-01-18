package com.jamesonli.paymentdemo.common;

/**
 * Created by james on 1/16/16.
 *
 * PaymentCheckoutData is used to initialize the checkout process.
 * Provides the checkout flow with information necessary to provide loan options.
 */
public class PaymentCheckoutData {

    public String description;
    public double price;

    public PaymentCheckoutData(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
