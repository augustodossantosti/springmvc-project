/*
 * springproject 1.0 3 de jan de 2017
 * 
 * Copyright (c) 2016, hyperCLASS. All rights reserved. hyperCLASS
 * proprietary/confidential. Use is subject to license terms.
 */
package br.com.hyperclass.springproject.infra.springconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * A classe <code>WebConfig</code> contém configurações 
 *
 * @author Augusto dos Santos
 * @version 1.0 3 de jan de 2017
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"br.com.hyperclass.springproject"})
public class WebConfig extends WebMvcConfigurerAdapter {

	/**
	 * Configurar o gerenciamento de conteúdo estático, para evitar que o DispatcherServlet
	 * tenha que lidar, por exemplo, com requisições a imagens e folhas de estilo.
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
