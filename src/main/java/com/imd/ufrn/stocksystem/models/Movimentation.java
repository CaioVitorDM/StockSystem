package com.imd.ufrn.stocksystem.models;

import com.imd.ufrn.stocksystem.models.enums.MovimenationType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "movimentations")
public class Movimentation extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "id_productSK", referencedColumnName = "id")
    private ProductStockKeeping productStockKeeping;

    @Column(name = "movimentation_type", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo tipo de movimentação não pode ser nulo")
    private MovimenationType movimenationType;

    @Column(name = "amount", nullable = false)
    @NotNull(message = "O campo quantidade é obrigatório")
    private int amount;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        Movimentation movimentation = (Movimentation) o;
        return Objects.equals(productStockKeeping, movimentation.productStockKeeping)
                && Objects.equals(movimenationType, movimentation.movimenationType)
                && Objects.equals(amount, movimentation.amount)
                && Objects.equals(user, movimentation.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), productStockKeeping, movimenationType, amount, user);
    }

}
