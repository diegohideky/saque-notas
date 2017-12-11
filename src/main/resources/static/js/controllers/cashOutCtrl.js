/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por controlar o two-way-data-binding da parte de Saque
 **/
(function () {
  'use strict';

  angular.module('App')
    .controller('cashOutCtrl', [ '$scope', 'auth', 'alerts', 'api',
      function ($scope, auth, alerts, api) {
        $scope.form = {
          user: auth.getUser(),
          value: 0
        };

        // Verifica se usuário tem acesso à página
        auth.canAccessCashOut();

        //Busca valores de cédulas disponíveis
        api.getCashValues().then(function (res) {
          $scope.values = res.data;
        });

        //Efetua Saque no backend
        $scope.submitCashOut = function () {
          clear();

          //Realiza a request
          api.cashOut($scope.form).then(function (res) {
            if (res.data.length !== 0) {
              // Mostra as cédulas recebidas
              $scope.valuesGot = groupValues(res.data);

              // Retira o valor sacado do saldo do usuário
              $scope.form.user.balance -= $scope.form.value;

              // Atualiza usuário no Cookie
              auth.setUser($scope.form.user);

              alerts.success('Saque efetuado com sucesso!');
            } else {
              alerts.error('Você não pode sacar esta quantia');
            }
          });
        };

        // Agrupa valores de notas
        function groupValues(values) {
          var valuesGotGroup = [];

          $scope.values.forEach(function (v1) {
            var length = 0;

            values.forEach(function (v2) {
              // Se o valor da cédula conter nas notas disponíveis
              if (v1 === v2) length ++;
            });

            // Se houver ao menos um nota
            if (length > 0) {
              // Adiciona na lista
              valuesGotGroup.unshift({ value: v1, quantity: length });
            }
          });

          return valuesGotGroup;
        }

        function clear() {
          $scope.error = "";
          $scope.valuesGot = [];
        }
      }]
    );
}());