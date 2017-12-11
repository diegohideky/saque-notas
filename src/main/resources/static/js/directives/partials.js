/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de diretivas de componentes comuns para todas as páginas
 **/
(function () {
  'use strict';

  angular.module('App')
    .directive('bankCashHeader', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/bank-cash-header.html',
        controller: 'headerCtrl'
      }
    }])
    .directive('bankCashFooter', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/bank-cash-footer.html'
      }
    }]);
}());