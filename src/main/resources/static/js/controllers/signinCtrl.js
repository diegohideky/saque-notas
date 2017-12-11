/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por controlar o two-way-data-binding do Signin
 **/
(function () {
  'use strict';

  angular.module('App')
    .controller('signinCtrl', [ '$scope', '$location', 'alerts', 'api',
      function ($scope, $location, alerts, api) {
        $scope.form = {role: 'USER'};

        $scope.submit = function() {

          if ($scope.form.password === $scope.form.passwordRepeat) {
          	api.saveUser($scope.form).then(function (res) {
              if (res.status === 201) {
                alerts.success('Usuário cadastrado! Agora faça seu login');

                $location.path('/login');
              } else {
                alerts.error('Não foi possível registrar usuário');
              }
            });
          }	else {
          	alerts.error('Senhas não estão iguais');
          }
        };
      }]
    );
}());