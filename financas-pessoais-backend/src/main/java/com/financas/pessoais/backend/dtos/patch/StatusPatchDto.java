package com.financas.pessoais.backend.dtos.patch;

import com.financas.pessoais.backend.enums.UserState;
import lombok.Data;

@Data
public class StatusPatchDto {
    private UserState state;
}
