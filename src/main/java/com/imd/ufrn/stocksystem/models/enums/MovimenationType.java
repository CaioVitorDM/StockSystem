package com.imd.ufrn.stocksystem.models.enums;

public enum MovimenationType {

    STOCK_IN("Stock In"),
    STOCK_OUT("Stock Out"),
    LOAN("Loan"),
    SALE("Sale"),
    UNDO("Undo");

    private final String description;

    MovimenationType(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
