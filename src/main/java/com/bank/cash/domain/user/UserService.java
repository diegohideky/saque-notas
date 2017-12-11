package com.bank.cash.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 * @version 1.0
 *
 * Classe de Serviço de Usuário
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * O método é reponsável por salvar um objeto usuário.
     * Caso o usuário já exista no banco de dados e retornado uma exceção
     * @param user
     * @return User
     * @throws ExistUserException
     */
    public User save(final User user) throws ExistUserException {
        User userEntity = loadUserByUsername(user.getUsername());
        if (userEntity != null) throw new ExistUserException();
        else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            // Gera o hash da senha
            String encodedPassword = encoder.encode(user.getPassword());

            // Cria novo usuário
            userEntity = new User(user.getUsername(), encodedPassword, user.getBalance(), user.getRole());
            // Salva no banco
            userRepository.save(userEntity);
        }
        return userEntity;
    }

    /**
     * O método é reponsável por editar um objeto usuário.
     * @param user
     */
    public User edit(final User user) {
        // Atualiza usuário
        return userRepository.save(new User(user.getId(), user.getUsername(), user.getPassword(), user.getBalance(), user.getRole()));
    }

    /**
     * O método é responsável por deletar usuário.
     * @param user
     */
    public void delete(final User user) {
        userRepository.delete(user);
    }

    /**
     * O método é responsável por retornar um usuário realizando a busca por nome
     * @param username
     * @return User
     */
    public User loadUserByUsername(String username) {
        User userEntity = this.userRepository.findByUsername(username);
        return userEntity;
    }

    /**
     * O método é responsável por retornar uma lista de usuários.
     * @return List<User>
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * O método é responsável por conferir a senha
     * @param password
     * @param hash
     * @return Boolean
     */
    public Boolean checkPassword(String password, String hash) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        return encoder.matches(password, hash);
    }
}
