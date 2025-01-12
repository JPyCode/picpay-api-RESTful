package me.henji.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import me.henji.picpaysimplificado.dtos.UserDTO;

import java.math.BigDecimal;

@Entity(name="users")
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String document;
    @Column(unique = true)
    private String email;
    private String password;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    public User(UserDTO data) {
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.document = data.document();
        this.email = data.email();
        this.password = data.password();
        this.balance = data.value();
        this.userType = data.userType();
    }


    public UserType getUserType() {
        return userType;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal value) {
        this.balance = value;
    }

    public String getEmail() {
        return email;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getPassword() {
        return password;
    }
}
