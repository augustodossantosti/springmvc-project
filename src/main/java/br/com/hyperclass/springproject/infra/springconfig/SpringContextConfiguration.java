/*
 * springproject 1.0 3 de jan de 2017
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.springproject.infra.springconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.hyperclass.springproject.infra.dao.CustomerDAO;

/**
 * A classe <code>SpringContextConfiguration</code> contém os beans que
 * estarão disponíveis no contexto do Spring para serem injetados quando
 * necessário.
 *
 * @author Augusto dos Santos
 * @version 1.0 3 de jan de 2017
 */
@Configuration
public class SpringContextConfiguration {
	
	@Bean
	public CustomerDAO customerDAO() {
		return new CustomerDAO();
	}

}
