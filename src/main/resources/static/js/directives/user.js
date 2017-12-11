/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de diretivas de Usuário
 *
 * Todas as partes da view que compõem a parte de Usuário estão definidas neste módulo
 **/
(function () {
  'use strict';

  angular.module('App')
    .directive('userForm', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/user/user-form.html'
      }
    }])
    .directive('userList', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/user/user-list.html'
      }
    }]);
}());
