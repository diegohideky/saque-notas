/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de gerenciamento de rotas
 * Como o projeto é simples, não foi necessário gerenciar mais de uma única rota
 **/
(function () {
  'use strict';

  angular.module('App').config(['$routeProvider', function ($routeProvider) {
    $routeProvider
      .when('/cash-out', {
        templateUrl: 'views/pages/cash-out.html',
        controller: 'cashOutCtrl'
      })
      .when('/users', {
        templateUrl: 'views/pages/users.html',
        controller: 'userCtrl'
      })
      .when('/login', {
        templateUrl: 'views/pages/login.html',
        controller: 'loginCtrl'
      })
      .when('/signin', {
        templateUrl: 'views/pages/signin.html',
        controller: 'signinCtrl'
      })
      .otherwise({
        redirectTo: '/login'
      });
  }]);
}());
