package com.imd.ufrn.stockservice.models;

import com.imd.ufrn.stockservice.models.enums.UF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.hibernate.annotations.Where;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
@Table(name = "stocks")
@Where(clause = "active = true")
public class Stock extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_store")
    private Store store;

    @Column(name = "location")
    private String location;

    @Column(name = "uf", nullable = false)
    @NotNull(message = "O campo UF é obrigatório")
    private UF uf;


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