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
 */
public class LoanOptionsAdapter extends RecyclerView.Adapter<LoanOptionViewHolder> {

    private List<LoanOption> loanOptionList;
    private Context context;

    public LoanOptionsAdapter(Context context, List<LoanOption> loanOptionList) {
        this.loanOptionList = loanOptionList;
        this.context = context;
    }

    @Override
    public LoanOptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.button_rounded_corners, parent, false);

        return new LoanOptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(LoanOptionViewHolder holder, int position) {
        LoanOption curOption = loanOptionList.get(position);

        holder.optionLabel.setText(String.format(context.getString(R.string.button_loan_option_text),
                curOption.amountPerMonth, curOption.numberOfMonths));
    }

    @Override
    public int getItemCount() {
        return loanOptionList == null ? 0 : loanOptionList.size();
    }
}
