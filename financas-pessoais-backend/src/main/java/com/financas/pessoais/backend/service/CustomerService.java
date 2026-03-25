package com.financas.pessoais.backend.service;

import com.financas.pessoais.backend.dtos.CustomerDto;
import com.financas.pessoais.backend.enums.UserState;
import com.financas.pessoais.backend.mappers.CustomerMapper;
import com.financas.pessoais.backend.models.Customer;
import com.financas.pessoais.backend.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createCustomer(CustomerDto customerDto) {
        Customer newCustomer = customerMapper.customerDtoToCustomer(customerDto);
        newCustomer.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        this.customerRepository.save(newCustomer);
    }

    public Optional<Customer> findCustomerById(UUID id) {
        return this.customerRepository.findById(id);
    }

    public Optional<Customer> findCustomerByEmail(String email) {
        return this.customerRepository.findByLoginData_Email(email);
    }

    @Transactional
    public void patchCustomer(UUID id, CustomerDto customerDto) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        if (customerDto.getLoginData() != null && customerDto.getPassword() != null) {
            customerDto.setPassword(passwordEncoder.encode(customerDto.getPassword()));
        }
        this.customerMapper.mappingCustomerPatch(customerDto, customer);
        this.customerRepository.save(customer);
    }

    public void alterCustomerStatus(UUID id, UserState userState) {
        Customer customer = this.customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        customer.setUserState(userState);
        this.customerRepository.save(customer);
    }

}
