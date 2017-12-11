/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por controlar o two-way-data-binding do Login
 **/
(function () {
  'use strict';

  angular.module('App')
    .controller('loginCtrl', [ '$scope', 'auth','alerts', 'api',
      function ($scope, auth, alerts, api) {

        // Verifica se o usuário está logado
        auth.isLogged();

        $scope.submit = function() {

          api.loginUser($scope.form).then(function (res) {
            if (res.status === 200) {
              var user = res.data;
              auth.setUser(user);

              auth.isLogged();
            } else {
              alerts.error('Usuário ou senha inválido');
            }
          }).catch(function () {
            // Erro gerado quando existem mais de 5 usuários logados
            alerts.error('Desculpe, já existem 5 usuários conectados!');
          });
        };
      }]
    );
}());