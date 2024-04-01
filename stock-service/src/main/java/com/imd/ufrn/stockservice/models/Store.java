package com.imd.ufrn.stockservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "stores")
@Where(clause = "active = true")
public class Store extends BaseEntity {

    @Column(name = "name", nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @Column(name = "cnpj", nullable = false, unique = true)
    @NotBlank(message = "O campo cnpj é obrigatório")
    private String cnpj;


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Store store = (Store) o;
        return Objects.equals(name, store.name)
                && Objects.equals(cnpj, store.cnpj);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, cnpj);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}