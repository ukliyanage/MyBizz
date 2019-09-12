package com.example.mybiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class ListIncomeAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public ListIncomeAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
        TextView DATE,SOURCE,AMOUNT;

    }

    public void add(Object object){
        super.add(object);
        list.add(object);
    }

    public int getCount(){
        return list.size();
    }

    public Object getItem(int position){
        return list.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        LayoutHandler layoutHandler;
        if(row==null){
            LayoutInflater layoutInflater=(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row=layoutInflater.inflate(R.layout.row_income_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.SOURCE=(TextView)row.findViewById(R.id.text_income_source);
            layoutHandler.DATE=(TextView)row.findViewById(R.id.text_income_date);
            layoutHandler.AMOUNT=(TextView)row.findViewById(R.id.text_income_amount);
            row.setTag(layoutInflater);
        }
        else{
            layoutHandler=(LayoutHandler)row.getTag();

        }

        IncomeProvider incomeProvider=(IncomeProvider) this.getItem(position);
        layoutHandler.SOURCE.setText(incomeProvider.getSource());
        layoutHandler.DATE.setText(incomeProvider.getDate());
        layoutHandler.AMOUNT.setText(incomeProvider.getAmount());

//        return super.getView(position, convertView, parent);
        return row;

    }
}
