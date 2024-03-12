package com.imd.ufrn.stocksystem.models;

import com.imd.ufrn.stocksystem.models.enums.UF;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "stocks")
@Where(clause = "active = true")
public class Stock extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "id_store")
    private Store store;

    @Column(name = "location")
    private String location;

    @Column(name = "uf", nullable = false)
    @NotNull(message = "O campo UF é obrigatório")
    private UF uf;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Stock stock = (Stock) o;
        return Objects.equals(store, stock.store)
                && Objects.equals(location, stock.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), store, location);
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}
