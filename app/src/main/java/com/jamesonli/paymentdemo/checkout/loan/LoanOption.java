package com.jamesonli.paymentdemo.checkout.loan;

/**
 * Created by james on 1/16/16.
 *
 * LoanOption holds data for each possible loan choice
 */
public class LoanOption {
    public double amountPerMonth;
    public int numberOfMonths;

    public LoanOption(double amountPerMonth, int numberOfMonths) {
        this.amountPerMonth = amountPerMonth;
        this.numberOfMonths = numberOfMonths;
    }
}
