package com.financas.pessoais.backend.models;

import com.financas.pessoais.backend.enums.UserState;
import com.financas.pessoais.backend.enums.UserType;
import com.financas.pessoais.backend.models.wrappers.LoginData;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "customer")
@AllArgsConstructor()
@NoArgsConstructor()
@Getter()
@Setter()
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "register_date", columnDefinition = "TIMESTAMP")
    private LocalDateTime registerDate = LocalDateTime.now();

    @Embedded
    private LoginData loginData;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", length = 8)
    private UserType userType = UserType.USER;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_state", length = 25)
    private UserState userState = UserState.ACTIVE;

    public void setPassword(String password) {
        this.loginData.setPassword(password);
    }
}
