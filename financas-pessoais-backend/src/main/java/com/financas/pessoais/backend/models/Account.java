package com.financas.pessoais.backend.models;

import com.financas.pessoais.backend.models.enums.AccountType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity()
@Table(name = "account")
@AllArgsConstructor()
@NoArgsConstructor()
@Getter()
@Setter()
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @NotBlank
    @Column(name = "bank_name", nullable = false, columnDefinition = "VARCHAR(30)")
    private String bankName;

    @NotNull
    @Column(name = "initial_balance", nullable = false, columnDefinition = "DECIMAL(10, 4)")
    private BigDecimal initialBalance;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_type", columnDefinition = "VARCHAR(8) DEFAULT 'CURRENT'")
    private AccountType accountType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, columnDefinition = "UUID")
    private Customer customer;

}
