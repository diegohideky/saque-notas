package com.bank.cash.domain.cashOut;

import com.bank.cash.domain.user.User;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Criado em 08/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável pelos dados de Saque
 **/
@Data
public class CashOut {

    @Autowired
    private User user;

    private Integer value;
}
