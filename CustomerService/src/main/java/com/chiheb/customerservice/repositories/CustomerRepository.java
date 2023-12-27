package com.chiheb.customerservice.repositories;

import com.chiheb.customerservice.entities.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
