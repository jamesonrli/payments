package com.jamesonli.paymentdemo.checkout.loan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.jamesonli.paymentdemo.R;

/**
 * Created by james on 1/16/16.
 */
public class LoanOptionViewHolder extends RecyclerView.ViewHolder {

    TextView optionLabel;
    View buttonGroup;

    public LoanOptionViewHolder(View itemView) {
        super(itemView);

        optionLabel = (TextView) itemView.findViewById(R.id.button_rounded_corners_label);
        buttonGroup = itemView.findViewById(R.id.button_rounded_corners_view);

    }
}
