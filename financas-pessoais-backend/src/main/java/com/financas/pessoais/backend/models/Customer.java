package com.financas.pessoais.backend.models;

import com.financas.pessoais.backend.models.enums.UserState;
import com.financas.pessoais.backend.models.enums.UserType;
import com.financas.pessoais.backend.models.wrappers.LoginData;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity()
@Table(name = "user")
@AllArgsConstructor()
@NoArgsConstructor()
@Getter()
@Setter()
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @NotBlank
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(45)")
    private String name;

    @Column(name = "register_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registerDate;

    @NotNull
    @Valid
    @Embedded
    private LoginData loginData;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", columnDefinition = "VARCHAR(8) DEFAULT 'USER'")
    private UserType userType;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "user_state", columnDefinition = "VARCHAR(9) DEFAULT 'ACTIVE'")
    private UserState userState;

}
