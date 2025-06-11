package com.financas.pessoais.backend.models.wrappers;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginData {

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "VARCHAR(90)")
    @NotBlank()
    @Email()
    private String email;

    @Column(name = "password", nullable = false, columnDefinition = "VARCHAR(80)")
    @NotBlank()
    private String password;

}
