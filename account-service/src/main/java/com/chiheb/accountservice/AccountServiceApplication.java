package com.chiheb.accountservice;

import com.chiheb.accountservice.clients.CustomerRestClient;
import com.chiheb.accountservice.entities.BankAccount;
import com.chiheb.accountservice.enums.AccountType;
import com.chiheb.accountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients //permet d activer l interface CustomerRestClient
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }
@Bean
    CommandLineRunner commandLineRunner(BankAccountRepository repository, CustomerRestClient customerRestClient){

        return args -> {
          customerRestClient.findAll().forEach(c->{
              BankAccount account1= BankAccount
                      .builder()
                      .currency("MAD")
                      .balance(Math.random()*80000)
                      .createdDate(LocalDate.now())//localDate.now(): c'est a dire la date sysytem
                      .type(AccountType.CURRENT_ACCOUNT)
                      .customerId(c.getId()) // customerId(Long.valueOf(1)):si par exemple je voulais dire que j'ai un customerId 1
                      .build();
              BankAccount account2= BankAccount
                      .builder()
                      .currency("MAD")
                      .balance(Math.random()*65432)
                      .createdDate(LocalDate.now())
                      .type(AccountType.SAVING_ACCOUNT)
                      .customerId(c.getId())
                      .build();
              repository.save(account1);
              repository.save(account2);
          });
        };
}
}
