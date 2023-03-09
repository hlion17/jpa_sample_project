package com.jpa_prac.customer.service;

import com.jpa_prac.customer.entity.CustomerEntity;
import com.jpa_prac.customer.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomerEntity findById(Long id) {
        Optional<CustomerEntity> foundCustomer = customersRepository.findById(id);
        if (foundCustomer.isPresent()) {
            return foundCustomer.get();
        }
        return null;
    }
}
