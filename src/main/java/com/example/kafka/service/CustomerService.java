package com.example.kafka.service;

import com.example.kafka.model.Customer;
import com.example.kafka.repositories.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Customer save(Customer customer){
        return repository.save(customer);
    }


}
