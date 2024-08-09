package com.example.again;

import com.example.again.model.Customer;
import com.example.again.model.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class AgainApplication {


	private static Logger log = LoggerFactory.getLogger(AgainApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(AgainApplication.class, args);

	}


}
