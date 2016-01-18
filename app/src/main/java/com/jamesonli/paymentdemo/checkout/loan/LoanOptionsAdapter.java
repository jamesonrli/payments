package com.jamesonli.paymentdemo.checkout.loan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jamesonli.paymentdemo.R;

import java.util.List;

/**
 * Created by james on 1/16/16.
 *
 * Adapter for loan option list. This adapter should be used with a RecyclerView
 */
public class LoanOptionsAdapter extends RecyclerView.Adapter<LoanOptionViewHolder> {

    private List<LoanOption> loanOptionList;
    private Context context;
    private LoanOptionHandler handler;

    private View currentSelectedButton;

    public LoanOptionsAdapter(Context context, LoanOptionHandler handler, List<LoanOption> loanOptionList) {
        this.loanOptionList = loanOptionList;
        this.context = context;
        this.handler = handler;
    }

    @Override
    public LoanOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.button_rounded_corners, parent, false);

        return new LoanOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LoanOptionViewHolder holder, int position) {
        final LoanOption curOption = loanOptionList.get(position);

        // initially, select the first option
        if(currentSelectedButton == null) {
            currentSelectedButton = holder.buttonGroup;
            currentSelectedButton.setSelected(true);
        }

        // loan option button label
        holder.optionLabel.setText(String.format(context.getString(R.string.button_loan_option_text),
                curOption.amountPerMonth, curOption.numberOfMonths));

        // loan option button
        holder.buttonGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSelectedButton.setSelected(false); // disable 'selected' state of previous option
                currentSelectedButton = holder.buttonGroup;
                currentSelectedButton.setSelected(true); // enable 'selected' state of new option
                handler.optionSelected(curOption);
            }
        });
    }

    @Override
    public int getItemCount() {
        return loanOptionList == null ? 0 : loanOptionList.size();
    }
}
