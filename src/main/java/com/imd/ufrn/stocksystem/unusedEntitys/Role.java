package com.imd.ufrn.stocksystem.unusedEntitys;

public enum Role {

    ADMIN("Administrator"),
    MANAGER("Manager"),
    EMPLOYEE("Employee");

    private final String description;

    Role(String description){
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
