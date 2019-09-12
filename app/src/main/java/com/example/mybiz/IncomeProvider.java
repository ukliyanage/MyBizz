package com.example.mybiz;

public class IncomeProvider {

    private String source;
    private String date;
    private String amount;

    public IncomeProvider(String source, String date, String amount){
        this.source=source;
        this.date=date;
        this.amount=amount;
    }

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


}
