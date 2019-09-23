package com.example.mybiz;

public class DataProviderEx {
    private String date;
    private String category;
    private String amount;

    public DataProviderEx(String dat,String cate,String amot){
        this.date=dat;
        this.category=cate;
        this.amount=amot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
