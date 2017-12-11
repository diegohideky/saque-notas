package com.bank.cash.api;

import com.bank.cash.domain.cashOut.CashOut;
import com.bank.cash.domain.cashOut.CashOutService;
import com.bank.cash.domain.user.User;
import com.bank.cash.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado em 08/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável pelo gerenciamento de requests feitas para Saque
 **/
@RestController
@RequestMapping(value = "/api/cash-out")
public class CashOutController {

    @Autowired
    private CashOutService cashOutService;

    @Autowired
    private UserService userService;

    // Realiza o saque do usuário retornando uma lista do menor número de notas que ele precisa
    @RequestMapping(method = RequestMethod.POST)
    public List<Integer> cashOut(@RequestBody CashOut cashOut) {
        List<Integer> valuesSent = new ArrayList<>();

        User user = userService.loadUserByUsername(cashOut.getUser().getUsername());

        // Se o saldo do usuário for menor que o valor de saque e o valor de saque for multiplo de 10
        if (user.getBalance() >= cashOut.getValue() && cashOut.getValue() % 10 == 0) {
            // Retorna o menor número de notas que o usuário precisa retirar
            valuesSent = cashOutService.getCalcOfNumberCash(cashOut.getValue());

            // subtrai o valor do saque no valor de Saldo do usuário
            user.setBalance(user.getBalance() - cashOut.getValue());

            // Atualiza o banco de dados
            userService.edit(user);
        }

        return valuesSent;
    }
}
