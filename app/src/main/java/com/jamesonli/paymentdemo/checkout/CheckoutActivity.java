package com.jamesonli.paymentdemo.checkout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import com.jamesonli.paymentdemo.R;
import com.jamesonli.paymentdemo.common.PaymentCheckoutData;

public class CheckoutActivity extends Activity implements CheckoutInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        switchContainerFragment(SignUpFragment.getInstance(this), R.id.checkout_container);
    }

    private void switchContainerFragment(Fragment fragment, int container) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(container, fragment).commit();
    }

    @Override
    public void confirmationButtonHandler(CheckoutFactory.CheckoutState state) {
        switchContainerFragment(CheckoutFactory.getNextCheckoutFragment(this, state), R.id.checkout_container);
    }

    @Override
    public CheckoutData getCheckoutData() {
        PaymentCheckoutData paymentCheckoutData = new PaymentCheckoutData("couch", 1000);
        CheckoutData checkoutData = new CheckoutData(paymentCheckoutData, "(415) 373-6849");
        return checkoutData;
    }

}
