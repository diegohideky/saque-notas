package com.bank.cash.domain.user;

/**
 * Criado em 07/12/2017.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Class reponsavel por retornar uma exceção quando o usuário existe no banco de dados
 */
public class ExistUserException extends Exception {

    private static final long serialVersionUID = 1997753363232807009L;

    public ExistUserException() {
        super("Usuário já existe!");
    }

    public ExistUserException(String message) {
        super(message);
    }
}
