package com.example.again.controller;

import com.example.again.AgainApplication;
import com.example.again.model.Customer;
import com.example.again.model.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AwayController {

    @Autowired
    private CustomerRepository repository;

    private static Logger log = LoggerFactory.getLogger(AwayController.class);
    @GetMapping("/call")
    public String getCall(){
        List allCustomers = repository.findAll();
        log.info("Number of customers: " + allCustomers.size());

        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        log.info("Saving new customer...");
        repository.save(newCustomer);

        allCustomers = repository.findAll();
        log.info("Number of customers: " + allCustomers.size());
        return "hello";
    }
}
