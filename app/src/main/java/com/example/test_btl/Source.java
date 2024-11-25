package com.example.test_btl;

public class Source {
    private String name;
    private double amount;
    private String sourceFrom;

    public Source(String name, double amount, String sourceFrom) {
        this.name = name;
        this.amount = amount;
        this.sourceFrom = sourceFrom;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getSourceFrom() {
        return sourceFrom;
    }
}
