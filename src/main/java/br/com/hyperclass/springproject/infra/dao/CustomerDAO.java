/*
 * springproject 1.0 3 de jan de 2017
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.springproject.infra.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.hyperclass.springproject.domain.Customer;

/**
 * A classe <code>CustomerDAO<code> é responsável por persistir os
 * clientes cadastrados. Não há conexão com banco de dados neste exemplo
 * apenas uma lista estática para simula-lo.
 *
 * @author Augusto dos Santos
 * @version 1.0 3 de jan de 2017
 */
public class CustomerDAO {
	
	private Long id = 1L;
	private List<Customer> customers = new ArrayList<>();
	
	public CustomerDAO() {
		register(new Customer("John", "Doe", "djohn@gmail.com", "121-232-3435"));
		register(new Customer("Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
		register(new Customer("Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
	}

	/**
	 * Registra um novo cliente.
	 * @param customer O novo cliente a ser registrado.
	 * @return O cliente recém registrado na aplicação.
	 */
	public Customer register(final Customer customer) {
		customer.setId(id);
		customers.add(customer);
		id++;
		return customer;
	}

	/**
	 * Remove os registros de um determinado cliente.
	 * @param id O id do cliente a ser removido.
	 * @throws CustomerNotFoundException Cliente não encontrado.
	 */
	public void delete(Long id) throws CustomerNotFoundException {
		for (Customer customer : customers) {
			if (customer.getId().equals(id)) {
				customers.remove(customer);
				return;
			}
		}
		throw new CustomerNotFoundException();
	}

	/**
	 * Atualiza os registros de um determinado cliente.
	 * @param customer O novo cliente a ser registrado.
	 * @return O cliente cujos dados foram atualizados.
	 */
	public Customer update(final Long id, final Customer customer) throws CustomerNotFoundException {
		for (Customer registeredCustomer : customers) {
			if (registeredCustomer.getId().equals(id)) {
				registeredCustomer.setFirstName(customer.getFirstName());
				registeredCustomer.setLastName(customer.getLastName());
				registeredCustomer.setEmail(customer.getEmail());
				registeredCustomer.setMobile(customer.getMobile());
				return registeredCustomer;
			}
		}
		throw new CustomerNotFoundException();
	}

	/**
	 * Busca um cliente com um id específico.
	 * @return O cliente com o id informado.
	 * @throws CustomerNotFoundException Cliente não encontrado.
	 */
	public Customer search(final Long id) throws CustomerNotFoundException {
		for (Customer customer : customers) {
			if (customer.getId().equals(id)) {
				return customer;
			}
		}
		throw new CustomerNotFoundException();
	}
	
	/**
	 * Retorna todos os clientes cadastrados.
	 * @return Uma lista com todos os clientes cadastrados na aplicação.
	 */
	public List<Customer> getRegisteredCustomers() {
		return Collections.unmodifiableList(customers);
	}
}
