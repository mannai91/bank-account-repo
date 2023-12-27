package com.chiheb.customerservice;

import com.chiheb.customerservice.config.GlobalConfig;
import com.chiheb.customerservice.entities.Customer;
import com.chiheb.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)//au demarage traite moi la classe globalconfig
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository repository){
		return args -> {

			Customer customer1=	Customer.builder()
					.firstName("Mannai")
					.lastName("chiheb")
					.email("chiheb.mannai@esprit.tn")
					.build();
			Customer customer2=	Customer.builder()
					.firstName("laouini")
					.lastName("houssem")
					.email("houssem.laouini@esprit.tn")
					.build();
			repository.save(customer2);
			repository.save(customer1);


			/*List<Customer> listCustomers=List.of(
					Customer.builder()
							.firstName("Mannai")
							.lastName("chiheb")
							.email("chiheb.mannai@esprit.tn")
							.build(),
					Customer.builder()
							.firstName("laouini")
							.lastName("houssem")
							.email("houssem.laouini@esprit.tn")
							.build()
			);
			repository.saveAll(listCustomers);*/
        };
}
}
