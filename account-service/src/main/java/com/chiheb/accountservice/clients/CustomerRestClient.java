package com.chiheb.accountservice.clients;

import com.chiheb.accountservice.model.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//avec cette interface je peux comminiquer avec la base de donnes de customer
//@FeignClient pour que cette interface devient une interface  open feign
@FeignClient(name = "CUSTOMER-SERVICE")//il faut que je passe le nom de mon micro service a contacter dans l'annotation.
public interface CustomerRestClient {

    @GetMapping("/customers/{id}")
    @CircuitBreaker(name="CustomerService",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name="CustomerService",fallbackMethod = "getAllCustomers")
    List<Customer> findAll();


    //dans une interface on peut declarer des default methodes
    default Customer getDefaultCustomer(Long id, Exception exception){
        Customer customer=new Customer();
        customer.setId(id);
        customer.setEmail("Not Valiable");
        customer.setFirstName("Not Valiable");
        customer.setLastName("Not Valiable");
        return customer;
    }
    default List<Customer> getAllCustomers(){
        return List.of();
    }
}
