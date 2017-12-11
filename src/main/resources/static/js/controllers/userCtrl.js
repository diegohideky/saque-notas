/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo responsável por controlar o two-way-data-binding da parte de Usuário
 **/
(function () {
  'use strict';

  angular.module('App')
    .controller('userCtrl', [ '$scope', 'auth', 'alerts', 'api',
      function ($scope, auth, alerts, api) {

        auth.canAccessUsers();

        // Busca todos usuário no backend
        api.getAllUsers().then(function (res) {
          if (res.data !== null) {
            $scope.users = res.data;
          }
        });

        // Conclui submissão de form
        $scope.submit = function () {
          $scope.form.role = 'USER';

          // Faz a request de um novo usuário
          api.saveUser($scope.form).then(function (res) {
            if (res.status === 201) {
              var user = res.data;

              if (user !== null) {
                // Adiciona novo usuário na tabela dinamicamente
                $scope.users.push(user);
                $scope.form = {};

                alerts.success('Usuário cadastrado com sucesso!');
              }
            } else {
              alerts.error('Houve algum erro!');
            }
          });
        };

        // Ativa modo de edição na tabela
        $scope.editMode = function (user) {
          $scope.users.forEach(function (user) {
            clearEdition(user);
          });

          user.edit = true;
          user.editUsername = user.username;
          user.editBalance = user.balance;
        };

        // Cancela modo de edição na tabela
        $scope.cancelEdition = function (user) {
          clearEdition(user);
        };

        // Atualiza usuário
        $scope.update = function (user) {
          var request = user;

          request.username = user.editUsername;
          request.balance = user.editBalance;

          // Realiza a request de atualização no back end
          api.editUser(request).then(function (res) {
            if (res.status === 200 ) {
              // Atualiza o usuário na tabela dinamicamente
              user.username = user.editUsername;
              user.balance = user.editBalance;
              clearEdition(user);

              alerts.success('Usuário atualizado!');
            } else {
              alerts.error('Não foi possível atualizar usuário!');
            }
          });
        };

        // Remove o usuário
        $scope.deleteUser = function (user) {

          // Realiza a request de remoção de usuário
          api.delUser(user).then(function (res) {
            if (res.status === 200) {
              // Remove o usuário da tabela dinamicamente
              var index = $scope.users.indexOf(user);
              $scope.users.splice(index, 1);

              alerts.success('Usuário removido com sucesso!');
            } else {
              alerts.error('Não foi possível remover usuário');
            }
          });
        };

        // Limpa variaveis de escopo
        function clearEdition(user) {
          delete user.edit;
          delete user.editUsername;
          delete user.editBalance;
        }
      }]
    );
}());