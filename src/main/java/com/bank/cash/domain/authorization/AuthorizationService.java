package com.bank.cash.domain.authorization;

import com.bank.cash.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Criado em 08/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe de Serviço de Autorização
 **/
@Service
public class AuthorizationService {

    @Autowired
    private Authorization authorization;

    public List<User> getAuthorizedUsers() {
        return authorization.getUsers();
    }

    public void addUser(User user) {
        this.authorization.add(user);
    }

    public void removeUser(User user) {
        this.authorization.remove(user);
    }

    public boolean isLogged(User user) {
        return this.authorization.isInList(user);
    }
}
