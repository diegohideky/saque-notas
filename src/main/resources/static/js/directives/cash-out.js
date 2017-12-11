/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de diretivas de Saque
 *
 * Todas as partes da view que compõem a parte de Saque estão definidas neste módulo
 **/
(function () {
  'use strict';

  angular.module('App')
    .directive('cashOutForm', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/cash-out/cash-out-form.html'
      }
    }])
    .directive('cashOutValues', [ function () {
      return {
        restrict: 'E',
        templateUrl: 'views/partials/cash-out/cash-out-values.html'
      }
    }]);
}());