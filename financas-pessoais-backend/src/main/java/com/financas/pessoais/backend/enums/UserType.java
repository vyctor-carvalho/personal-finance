package com.financas.pessoais.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserType {

    ADMIN("admin"),
    PREMIUM("premium"),
    USER("user");

    private final String type;

}
