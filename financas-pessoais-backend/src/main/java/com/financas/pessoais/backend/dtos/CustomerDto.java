package com.financas.pessoais.backend.dtos;

import com.financas.pessoais.backend.models.wrappers.LoginData;
import com.financas.pessoais.backend.enums.UserType;
import com.financas.pessoais.backend.enums.UserState;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private LoginData loginData;

    @NotNull
    private UserType userType;

    @NotNull
    private UserState userState;

    public String getPassword() {
        return this.loginData.getPassword();
    }

    public void setPassword(String password) {
        this.loginData.setPassword(password);
    }
}
