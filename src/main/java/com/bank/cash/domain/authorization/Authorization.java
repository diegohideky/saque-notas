package com.bank.cash.domain.authorization;

import com.bank.cash.domain.user.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email dieoghideky@gmail.com
 * @version 1.0
 *
 * Classe que contém os usuários logados e controla permissão
 **/
@Data
@Component
public class Authorization {

    private List<User> users = new ArrayList<>();

    // Função que adiciona usuário na lista de autorizados
    public void add(User user) {
        this.users.add(user);
    }

    // Função que remove usuário da lista de autorizados
    public void remove(User user) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUsername().equals(user.getUsername())) {
                this.users.remove(i);
            }
        }
    }

    // Função que verifica se usuário está na lista de autorizados
    public boolean isInList(User user) {
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUsername().equals(user.getUsername())) {
                return true;
            }
        }
        return false;
    }
}
