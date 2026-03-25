package com.financas.pessoais.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserState {

    ACTIVE("active"),
    INACTIVE("inactive"),
    BLOCKED("blocked");

    private final String status;

}
