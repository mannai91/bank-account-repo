package com.chiheb.customerservice.controllers;

import com.chiheb.customerservice.entities.Customer;
import com.chiheb.customerservice.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {

    CustomerRepository repository;

    @GetMapping("/customers")
    public List<Customer> findAllCustomers(){
        return repository.findAll();
    }
    @GetMapping("/customers/{idCustomer}")
    public Customer findByIdCustomers(@PathVariable Long idCustomer){
        return repository.findById(idCustomer).get();
    }
}
