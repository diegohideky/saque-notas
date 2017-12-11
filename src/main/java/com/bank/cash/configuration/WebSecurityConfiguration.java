package com.bank.cash.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Criado em 07/12/2017.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável pelo gerenciamento de segurança da aplicação
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    // Spring Security foi utilizado apenas para gerar o Hash das senhas
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }
}