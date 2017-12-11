package com.bank.cash;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Criado em 07/12/2017
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe principal do projeto
 */
@SpringBootApplication
@EnableAutoConfiguration
public class BankCashApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankCashApplication.class, args);
    }
}
