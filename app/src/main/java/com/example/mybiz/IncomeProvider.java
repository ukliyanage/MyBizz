package com.example.mybiz;

public class IncomeProvider {
    private String date;
    private String source;
    private String amount;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public IncomeProvider(String date, String source, String amount){
        this.date=date;
        this.source=source;
        this.amount=amount;
    }
}

