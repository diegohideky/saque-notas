/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de Serviço de Autorização e Cookies
 **/
(function () {
  'use strict';

  angular.module('App')
    .service('auth', [ '$location', 'ipCookie', function ($location, ipCookie) {
      // Salva usuário em cookie
      this.setUser = function (user) {
        ipCookie('user', user);
      };

      // Retorna o usuário salvo em cookie
      this.getUser = function () {
        return ipCookie('user');
      };

      // Remove usuário do cookie
      this.removeUser = function () {
        ipCookie.remove('user');
      };

      // Verifica se o usuário está logado e envia-o para página autorizada
      this.isLogged = function () {
        var user = this.getUser();

        if (typeof user !== 'undefined' && user.role === 'ADMIN') {
          $location.path('/users');
        } else if (typeof user !== 'undefined' && user.role === 'USER') {
          $location.path('/cash-out');
        }
      };

      // Verifica se usuário logado tem permissão para a página Users
      this.canAccessUsers = function () {
        var user = this.getUser();

        if (typeof user === 'undefined' || user.role === 'USER') {
          $location.path('/login');
        }
      };

      // Verifica se usuário logado tem permissão para a página Cash Out
      this.canAccessCashOut = function () {
        var user = this.getUser();

        if (typeof user === 'undefined' || user.role === 'ADMIN') {
          $location.path('/login');
        }
      };

      // Remove usuário do cookie e envia-o para a página de login
      this.logOut = function () {
        this.removeUser();

        $location.path('/login');
      };
    }]
  );
}());
