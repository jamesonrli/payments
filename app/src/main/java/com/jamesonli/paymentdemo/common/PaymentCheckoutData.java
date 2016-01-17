package com.jamesonli.paymentdemo.common;

/**
 * Created by james on 1/16/16.
 */
public class PaymentCheckoutData {

    public String description;
    public double price;

    public PaymentCheckoutData(String description, double price) {
        this.description = description;
        this.price = price;
    }
}
