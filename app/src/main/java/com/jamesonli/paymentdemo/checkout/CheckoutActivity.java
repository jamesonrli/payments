package com.jamesonli.paymentdemo.checkout;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import com.jamesonli.paymentdemo.R;

public class CheckoutActivity extends Activity implements CheckoutInteraction {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        switchContainerFragment(SignUpFragment.getInstance(), R.id.checkout_container);
        switchContainerFragment(DetailsFragment.getInstance(), R.id.checkout_container);
    }

    private void switchContainerFragment(Fragment fragment, int container) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(container, fragment).commit();
    }

    @Override
    public void confirmationButtonHandler() {

    }

}
