package com.financas.pessoais.backend.controllers;

import com.financas.pessoais.backend.dtos.patch.StatusPatchDto;
import com.financas.pessoais.backend.enums.UserState;
import com.financas.pessoais.backend.dtos.CustomerDto;
import com.financas.pessoais.backend.models.Customer;
import com.financas.pessoais.backend.service.AccountService;
import com.financas.pessoais.backend.service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController()
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CostumerController {
    private final CustomerService customerService;
    private final AccountService accountService;

    @PostMapping()
    public ResponseEntity<Void> postCustomer(@Valid @RequestBody CustomerDto customerDto) {
        this.customerService.createCustomer(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable UUID id) {
        Customer customer = this.customerService.findCustomerById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        return ResponseEntity.status(HttpStatus.FOUND).body(customer);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> patchCustomer (@PathVariable UUID id, @RequestBody CustomerDto customerDto) {
        this.customerService.patchCustomer(id, customerDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<Void> patchCustomerStatus(@PathVariable UUID id, @RequestBody StatusPatchDto statusPatchDto) {
        this.customerService.alterCustomerStatus(id, statusPatchDto.getState());
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
