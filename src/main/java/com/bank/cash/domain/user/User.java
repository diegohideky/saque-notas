package com.bank.cash.domain.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe responsável pelos dados de Usuário
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 2353528370345499815L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 15, nullable = true)
    private String username;

    @Column(name = "password", length = 12 , nullable = true)
    private String password;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "role")
    private String role;

    public User() {
        super();
    }

    public User(Long id, String username, String password, Integer balance, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }

    public User(String username, String password, Integer balance, String role) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.role = role;
    }
}
