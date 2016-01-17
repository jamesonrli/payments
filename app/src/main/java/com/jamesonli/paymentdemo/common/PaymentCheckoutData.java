package com.jamesonli.paymentdemo.common;

/**
 * Created by james on 1/16/16.
 */
public class PaymentCheckoutData {

    private String description;
    private double price;

    public PaymentCheckoutData(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
