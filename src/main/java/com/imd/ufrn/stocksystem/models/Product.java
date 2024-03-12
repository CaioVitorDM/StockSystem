package com.imd.ufrn.stocksystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "products")
@Where(clause = "active = true")
public class Product extends BaseEntity{

    @Column(name = "name", nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "cost_price", nullable = false)
    @NotNull(message = "O campo de preço de custo não pode ser nulo")
    private BigDecimal costPrice;

    @Column(name = "sell_price", nullable = false)
    @NotNull(message = "O campo de preço de venda não pode ser nulo")
    private BigDecimal sellPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name)
                && Objects.equals(description, product.description)
                && Objects.equals(costPrice, product.costPrice)
                && Objects.equals(sellPrice, product.sellPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, description, costPrice, sellPrice);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }
}
