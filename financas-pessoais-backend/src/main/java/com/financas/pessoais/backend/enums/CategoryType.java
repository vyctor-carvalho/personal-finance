package com.financas.pessoais.backend.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryType {

    REVENUE("revenue"),
    EXPENSE("expenses");

    private String type;

}
