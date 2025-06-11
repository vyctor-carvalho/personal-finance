package com.financas.pessoais.backend.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "goal")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @NotBlank
    @Column(name = "title", nullable = false, columnDefinition = "VARCHAR(40)")
    private String title;

    @Column(name = "description", columnDefinition = "VARCHAR(100)")
    private String description;

    @NotNull
    @Column(name = "goal_value", nullable = false, columnDefinition = "DECIMAL(10, 4)")
    private BigDecimal goalValue;

    @NotNull
    @Column(name = "current_value", columnDefinition = "DECIMAL(10, 4)")
    private BigDecimal currentValue;

    @Column(name = "due_date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime dueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false, columnDefinition = "UUID")
    private Customer customer;

}
