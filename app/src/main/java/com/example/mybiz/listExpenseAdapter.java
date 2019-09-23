package com.example.mybiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

class listExpenseAdapter extends ArrayAdapter {
    List list=new ArrayList();

    public listExpenseAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    static class LayoutHandler
    {
        TextView date,category,amount;
    }
    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public Object getExpense(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row ==null)
        {
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.e_row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.date=(TextView)row.findViewById(R.id.text_date);
            layoutHandler.category=(TextView)row.findViewById(R.id.text_category);
            layoutHandler.amount=(TextView)row.findViewById(R.id.text_amount);
            row.setTag(layoutHandler);

        }
        else {
            layoutHandler =(LayoutHandler)row.getTag();

        }
        DataProviderEx dataProviderEx=(DataProviderEx)this.getExpense(position);
        layoutHandler.date.setText(dataProviderEx.getDate());
        layoutHandler.category.setText(dataProviderEx.getCategory());
        layoutHandler.amount.setText(dataProviderEx.getAmount());

        return row;
    }
}
