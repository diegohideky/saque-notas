package com.bank.cash.api;

import com.bank.cash.domain.authorization.AuthorizationService;
import com.bank.cash.domain.user.ExistUserException;
import com.bank.cash.domain.user.User;
import com.bank.cash.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável pelo gerenciamento de requests feitas para Usuário
 **/
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @Autowired
    private AuthorizationService authService;

    // Realiza o login do usuário na aplicação
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> loginUser(@RequestBody User user) {
        User userEntity = service.loadUserByUsername(user.getUsername());

        Boolean hasCorrectPassword = service.checkPassword(user.getPassword(), userEntity.getPassword());

        // Verifica se já existem 5 usuários logados e se o mesmo usuário já está logado
        if (authService.getAuthorizedUsers().size() < 5 || authService.isLogged(userEntity)) {
            // Verifica se a senha está correta
            if (hasCorrectPassword) {
                authService.addUser(userEntity);

                return new ResponseEntity(userEntity, HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.CONFLICT);
            }
        } else {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
    }

    // Remove o usuário da lista de usuários autorizados
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity<User> logoutUser(@RequestBody User user) {
        // Pesquisa usuário
        User userEntity = service.loadUserByUsername(user.getUsername());

        // Remove usuário da lista de autorizados
        authService.removeUser(userEntity);

        return new ResponseEntity(HttpStatus.OK);
    }

    // Salva o usuário no banco de dados
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        try {
            // Salva o usuário no banco
            User userEntity = service.save(user);
            return new ResponseEntity(userEntity, HttpStatus.CREATED);
        } catch (ExistUserException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    // Atualiza o usuário no banco de dados
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<User> edit(@RequestBody User user) {
        // Atualiza usuário no banco
        User userEntity = service.edit(user);
        return new ResponseEntity(userEntity, HttpStatus.OK);
    }

    // Remove o usuário do banco de dados
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@RequestBody User user) {
        // Remove usuário do banco
        service.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    // Retorna a lista de todos os usuários
    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public ResponseEntity<User> getAll() {
        return new ResponseEntity(service.getAllUsers(), HttpStatus.OK);
    }
}
