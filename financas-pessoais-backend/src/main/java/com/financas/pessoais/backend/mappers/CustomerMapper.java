package com.financas.pessoais.backend.mappers;

import com.financas.pessoais.backend.dtos.CustomerDto;
import com.financas.pessoais.backend.models.Customer;
import com.financas.pessoais.backend.models.wrappers.LoginData;
import org.mapstruct.*;

import java.util.UUID;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registerDate", ignore = true)
    Customer customerDtoToCustomer(CustomerDto customerDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registerDate", ignore = true)
    void mappingCustomerPatch(CustomerDto customerDto, @MappingTarget Customer customer);

    void patchLoginData(LoginData loginData, @MappingTarget LoginData existingLoginData);
}
