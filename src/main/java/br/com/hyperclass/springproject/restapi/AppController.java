/*
 * springproject 1.0 3 de jan de 2017
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.springproject.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.hyperclass.springproject.domain.Customer;
import br.com.hyperclass.springproject.infra.dao.CustomerDAO;
import br.com.hyperclass.springproject.infra.dao.CustomerNotFoundException;

/**
 * A classe <code>AppController</code> contém as rotas de acesso 
 * aos recursos da aplicação.
 *
 * @author Augusto dos Santos
 * @version 1.0 3 de jan de 2017
 */
@RestController
public class AppController {
	
	@Autowired
	private CustomerDAO customerDAO;

	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {

		customerDAO.register(customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) throws CustomerNotFoundException {
		
		customerDAO.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) throws CustomerNotFoundException {

		customer = customerDAO.update(id, customer);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> searchCustomer(@PathVariable("id") Long id) throws CustomerNotFoundException {

		Customer customer = customerDAO.search(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	@GetMapping("/customers")
	public List<Customer> getRegisteredCustomers() {
		return customerDAO.getRegisteredCustomers();
	}

}
