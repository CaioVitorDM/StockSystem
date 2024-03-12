package com.imd.ufrn.stocksystem.models;

import com.imd.ufrn.stocksystem.models.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Where;

import java.util.Objects;

@Entity
@Table(name = "users")
@Where(clause = "active = true")
public class User extends BaseEntity{

    @Column(name = "name", nullable = false)
    @NotBlank(message = "O campo nome é obrigatório")
    private String name;

    @Column(name = "login", nullable = false)
    @NotBlank(message = "O campo login é obrigatório")
    private String login;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "O campo senha é obrigatório")
    @Size(min = 4, message = "A senha precisa ter, no mínimo, 4 caracteres")
    private String password;

    @Column(name = "email", nullable = false)
    @NotBlank(message = "O campo email é obrigatório")
    private String email;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo perfil não pode ser nulo")
    private Role role;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false;
        User user = (User) o;
        return Objects.equals(login, user.login)
                && Objects.equals(password, user.password) && role == user.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), login, password, role);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
