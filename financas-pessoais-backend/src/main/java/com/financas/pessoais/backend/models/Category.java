package com.financas.pessoais.backend.models;

import com.financas.pessoais.backend.models.enums.CategoryType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "category")
@AllArgsConstructor()
@NoArgsConstructor()
@Getter()
@Setter()
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "UUID DEFAULT gen_random_uuid()")
    private UUID id;

    @NotBlank
    @Column(name = "name", nullable = false, columnDefinition = "VARCHAR(20)")
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "VARCHAR(8)")
    private CategoryType type;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", columnDefinition = "UUID")
    private Customer customer;

}
