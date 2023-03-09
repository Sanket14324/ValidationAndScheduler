package com.customer.springboot;

import com.customer.springboot.model.Customer;
import com.customer.springboot.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class CustomerRestApiApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomerRestApiApplication.class, args);
    }

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public void run(String... args) throws Exception {

    }
}
