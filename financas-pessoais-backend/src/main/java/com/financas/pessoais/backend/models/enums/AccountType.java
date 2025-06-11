package com.financas.pessoais.backend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AccountType {

    CURRENT("current"),
    SAVINGS("savings"),
    SALARY("salary");

    private final String type;

}
