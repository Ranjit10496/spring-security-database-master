package com.sunglowsys.service;

import com.sunglowsys.domain.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer save(Customer customer);
    Customer update(Customer customer);
    Page<Customer> getAll(Pageable pageable);
    List<Customer> getAll();
    Optional<Customer> getOne(Long id);
    void delete(Long id);
}
