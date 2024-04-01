package com.imd.ufrn.stockservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "stocks")
@Where(clause = "active = true")
public class Stock extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_store")
    private Store store;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Stock stock = (Stock) o;
        return Objects.equals(store, stock.store);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), store);
    }


    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}