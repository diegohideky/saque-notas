/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por realizar requests ao back-end
 **/

(function () {
  'use strict';

  angular.module('App')
    .service('api', [ '$http', function ($http) {

      var headers = {'Content-type': 'application/json'};

      /**
       * Retorna todos os usuários
       *
       * User = {
       *   "id": 1,
       *   "username": "algumusuario",
       *   "password": "hash",
       *   "balance": 5000,
       *   "role": "USER"
       * }
       *
       * @return [User]
       */
      this.getAllUsers = function () {
        return $http.get('/api/user/all');
      };

      /**
       * Loga usuário no sistema
       *
       * User = {
       *   "id": 1,
       *   "username": "algumusuario",
       *   "password": "hash",
       *   "balance": 5000,
       *   "role": "USER"
       * }
       *
       * @return User
       */
      this.loginUser = function (request) {
        return $http.post('/api/user/login', request);
      };

      /**
      * Desloga usuário no sistema
      *
      * User = {
      *   "id": 1,
      *   "username": "algumusuario",
      *   "password": "hash",
      *   "balance": 5000,
      *   "role": "USER"
      * }
      *
      * @return Status 200
      */
      this.logoutUser = function (request) {
        return $http.post('/api/user/logout', request);
      };

      /**
       * Salva um novo usuário no banco
       *
       * request = {
	     *   "username": "algumusuario",
	     *   "balance": 1000
       * }
       *
       * @param request
       *
       * user = {
       *   "id": 1
	     *   "username": "algumusuario",
	     *   "balance": 1000
       * }
       *
       * @return user
       */
      this.saveUser = function (request) {
        return $http.post('/api/user', request);
      };

      /**
       * Atualiza usuário selecionado
       *
       * request = {
       *   "id" = 1
	     *   "username": "outronome",
	     *   "balance": 1000 <- outro valor
       * }
       *
       * @param request
       *
       * user = {
       *   "id" = 1
	     *   "username": "outronome",
	     *   "balance": 1000
       * }
       *
       * @return user
       */
      this.editUser = function (request) {
        return $http.put('/api/user', request);
      };

      /**
       * Remove usuário do banco de dados
       *
       * request = {
       *   "id" = 1
	     *   "username": "algumnome",
	     *   "balance": 5000
       * }
       *
       * @param request
       *
       * @return Status 200
       */
      this.delUser = function (request) {
        return $http.delete('/api/user', {
          data: request,
          headers: headers
        });
      };

      /**
       * Retorna os valores de cédulas disponíveis
       *
       * cashValues = [ 10, 20, 50, 100]
       *
       * @return cashValues
       */
      this.getCashValues = function () {
        return $http.get('/api/cash');
      };

      /**
       * Efetua o saque do usuário
       *
       * request = {
       *   "user": {
       *     "id" = 1
	     *     "username": "algumusuario",
	     *     "balance": 1000
       *   },
       *   "value": 80
       * }
       *
       * @param request
       *
       * response = [50, 20, 10]
       *
       * @return response
       */
      this.cashOut = function (request) {
        return $http.post('/api/cash-out', request);
      };
    }
  ]);
}());
