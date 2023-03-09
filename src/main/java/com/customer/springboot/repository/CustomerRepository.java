package com.customer.springboot.repository;

import com.customer.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
