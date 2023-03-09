package com.customer.springboot.controller;

import com.customer.springboot.exception.ResourceNotFoundException;
import com.customer.springboot.model.Customer;
import com.customer.springboot.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @PostMapping
    public Customer createCustomer(@Valid @RequestBody Customer customer){
        return customerRepository.save(customer);
    }


    @GetMapping("{name}")
    public ResponseEntity<List<Customer>> getCustomerByName(@PathVariable String name){

        List<Customer> customerList = customerRepository.findAll().stream().filter(customer -> Objects.equals(customer.getName(), name))
                .collect(Collectors.toList());
        if(customerList.size() == 0){
            throw new ResourceNotFoundException("Customer not exist with name :"+name);
        }

        return ResponseEntity.ok(customerList);
    }
    @PutMapping("{id}")
    public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id,@RequestBody Customer customerDetails ){
        Customer updateCustomer = customerRepository.findById(id)
                .orElseThrow(() ->new  ResourceNotFoundException("Customer not exist with id:"+id));

        updateCustomer.setName(customerDetails.getName());
        updateCustomer.setAge(customerDetails.getAge());

        customerRepository.save(updateCustomer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :"+id));

        customerRepository.delete(customer);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
