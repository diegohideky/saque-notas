package com.bank.cash.domain.cash;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Criado em 08/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe de Serviço de Notas
 **/
@Service
public class CashService {

    public List<Integer> getCashValues() {
        return new Cash().getCashValues();
    }
}
