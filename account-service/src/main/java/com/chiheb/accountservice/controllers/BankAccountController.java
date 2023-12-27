package com.chiheb.accountservice.controllers;

import com.chiheb.accountservice.clients.CustomerRestClient;
import com.chiheb.accountservice.entities.BankAccount;
import com.chiheb.accountservice.model.Customer;
import com.chiheb.accountservice.repositories.BankAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BankAccountController {
    private BankAccountRepository repository;
    private CustomerRestClient customerRestClient;
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
      List<BankAccount>  allAccounts=repository.findAll();
      allAccounts.forEach(acc->{
          acc.setCustomer(customerRestClient.findCustomerById(acc.getId()));
      });
        return allAccounts;
    }
    @GetMapping("/accounts/{id}")
    public BankAccount findBankAccountById(@PathVariable  Long id){
        BankAccount bankAccount = repository.findById(id).get();
        Customer customer =  customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;
    }
}
