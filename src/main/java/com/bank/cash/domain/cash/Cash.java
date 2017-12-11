package com.bank.cash.domain.cash;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email dieoghideky@gmail.com
 * @version 1.0
 *
 * Classe que contém os valores de Notas disponíveis para saque
 **/
public class Cash {

    public List<Integer> getCashValues() {
        List<Integer> cashValues = new ArrayList<>();

        cashValues.add(10);
        cashValues.add(20);
        cashValues.add(50);
        cashValues.add(100);

        return cashValues;
    }
}
