package com.bank.cash.domain.cashOut;

import com.bank.cash.domain.cash.CashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Criado em 08/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe de Serviço de Saque
 **/
@Service
public class CashOutService {

    @Autowired
    private CashService cashService;

    public List<Integer> getCalcOfNumberCash(Integer value) {
        List<Integer> values = cashService.getCashValues();
        List<Integer> valuesSent = new ArrayList<>();

        Collections.reverse(values);
        while(value > 0 ){
            for(Integer v: values) {
                if (value >= v) {
                    value -= v;

                    valuesSent.add(v);

                    break;
                }
            }
        }

        return valuesSent;
    }
}
