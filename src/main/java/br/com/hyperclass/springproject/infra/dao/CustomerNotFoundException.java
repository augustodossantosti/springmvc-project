/*
 * springproject 1.0 3 de jan de 2017
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.springproject.infra.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * A exceção <code>CustomerNotFoundException</code> indica, durante uma busca,
 * que o cliente não está cadastrado.
 *
 * @author Augusto dos Santos
 * @version 1.0 3 de jan de 2017
 */
@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Customer not found.")
public class CustomerNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

}
