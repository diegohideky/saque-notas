/**
 * Criado em 07/12/17.
 * @author Diego Hideky
 * @email diegohideky@gmail.com
 *
 * Módulo de Serviço de Alertas
 **/
(function () {
  'use strict';

  angular.module('App')
    .service('alerts', [ 'SweetAlert', function (SweetAlert) {
      this.success = function (text) {
        return SweetAlert.swal({
          title: 'Ótimo',
          text: text,
          type: 'success'
        });
      };

      this.error = function (text) {
        return SweetAlert.swal({
          title: 'Ops',
          text: text,
          type: 'error'
        });
      };
    }]
  );
}());
