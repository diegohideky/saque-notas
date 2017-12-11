package com.bank.cash.api;

import com.bank.cash.domain.cash.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável por gerenciar as requests feitas para Notas
 **/
@RestController
@RequestMapping(value = "/api/cash")
public class CashController {

    @Autowired
    private CashService service;

    @RequestMapping(method = RequestMethod.GET)
    public List<Integer> cashes() {
        return service.getCashValues();
    }
}
