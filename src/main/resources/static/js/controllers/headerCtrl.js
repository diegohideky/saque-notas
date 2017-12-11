/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por controlar o two-way-data-binding do Header
 **/
(function () {
  'use strict';

  angular.module('App')
    .controller('headerCtrl', [ '$scope', 'auth', 'alerts', 'api',
      function ($scope, auth, alerts, api) {

        $scope.logOut = function() {

          // Faz a request para retirar o usuário da lista de autorizados
          api.logoutUser(auth.getUser()).then(function (res) {
            if (res.status === 200) {
              // remove o usuário do cookie
              auth.logOut();
            } else {
              alerts.error('Não foi possível deslogar!');
            }
          });
        };
      }]
    );
}());
