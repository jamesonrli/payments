package com.jamesonli.paymentdemo.checkout;

import com.jamesonli.paymentdemo.checkout.loan.LoanOption;
import com.jamesonli.paymentdemo.common.LoanConstants;
import com.jamesonli.paymentdemo.common.PaymentCheckoutData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 1/16/16.
 */
public class CheckoutData {

    private PaymentCheckoutData merchantInput;
    private String phoneNumber;

    private JSONObject loanData;

    public CheckoutData(PaymentCheckoutData merchantInput, String phoneNumber) {
        this.merchantInput = merchantInput;
        this.phoneNumber = phoneNumber;
        this.loanData = getLoanData();
    }

    private JSONObject getLoanData() {
        JSONObject data = new JSONObject();

        try {
            data.put(LoanConstants.APPROVED_AMOUNT, 1000);
            data.put(LoanConstants.INTEREST, 20);
            data.put(LoanConstants.FIRST_DUE_DATE, "Feb 20, 2016");

            JSONArray loanOptions = new JSONArray();

            JSONObject tempOption1 = new JSONObject();
            tempOption1.put(LoanConstants.AMOUNT_PER_MONTH, 344.51);
            tempOption1.put(LoanConstants.NUM_MONTHS, 3);
            JSONObject tempOption2 = new JSONObject();
            tempOption2.put(LoanConstants.AMOUNT_PER_MONTH, 176.52);
            tempOption2.put(LoanConstants.NUM_MONTHS, 6);
            JSONObject tempOption3 = new JSONObject();
            tempOption3.put(LoanConstants.AMOUNT_PER_MONTH, 92.63);
            tempOption3.put(LoanConstants.NUM_MONTHS, 12);

            loanOptions.put(tempOption1);
            loanOptions.put(tempOption2);
            loanOptions.put(tempOption3);

            data.put(LoanConstants.LOAN_OPTIONS, loanOptions);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

    public PaymentCheckoutData getMerchantInput() {
        return merchantInput;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getInterestAmount(LoanOption option) {
        return option.amountPerMonth * option.numberOfMonths - loanData.optDouble(LoanConstants.APPROVED_AMOUNT);
    }

    public double getPaymentTotal(LoanOption option) {
        return option.amountPerMonth * option.numberOfMonths;
    }

    public double getApprovedAmount() {
        return loanData.optDouble(LoanConstants.APPROVED_AMOUNT);
    }

    public int getAPR() {
        return loanData.optInt(LoanConstants.INTEREST);
    }

    public List<LoanOption> getLoanOptions() {
        JSONArray optionsArray = loanData.optJSONArray(LoanConstants.LOAN_OPTIONS);
        List<LoanOption> resultLoanOptions = new ArrayList<>();

        for(int i=0; i<optionsArray.length(); i++) {
            JSONObject curOption = optionsArray.optJSONObject(i);
            resultLoanOptions.add(new LoanOption(curOption.optDouble(LoanConstants.AMOUNT_PER_MONTH),
                    curOption.optInt(LoanConstants.NUM_MONTHS)));
        }

        return resultLoanOptions;
    }

    public String getFirstDueDate() {
        return loanData.optString(LoanConstants.FIRST_DUE_DATE);
    }
}
