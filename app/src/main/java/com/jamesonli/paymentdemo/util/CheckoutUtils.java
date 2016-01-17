package com.jamesonli.paymentdemo.util;

import com.jamesonli.paymentdemo.common.LoanConstants;
import org.json.JSONObject;

/**
 * Created by james on 1/16/16.
 */
public class CheckoutUtils {
    public static int getMonthsFromLoanOption(JSONObject option) {
        return option.optInt(LoanConstants.NUM_MONTHS);
    }

    public static double getAmountPerMonthFromLoanOption(JSONObject option) {
        return option.optDouble(LoanConstants.AMOUNT_PER_MONTH);
    }
}
