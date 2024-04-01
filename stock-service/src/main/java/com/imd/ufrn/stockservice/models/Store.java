package com.imd.ufrn.stockservice.models;

import com.imd.ufrn.stockservice.models.enums.UF;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Column(name = "location", nullable = false)
    @NotBlank(message = "O campo localização é obrigatório")
    private String location;

    @Column(name = "cnpj", nullable = false)
    @NotBlank(message = "O campo cnpj é obrigatório")
    private String cnpj;

    @Column(name = "uf", nullable = false)
    @NotBlank(message = "O campo UF é obrigatório")
    @Enumerated(EnumType.STRING)
    private UF uf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public UF getUf() {
        return uf;
    }

    public void setUf(UF uf) {
        this.uf = uf;
    }
}