'use strict';
/** 
  * controller for angular-aside
  * Off canvas side menu to use with ui-bootstrap. Extends ui-bootstrap's $modal provider.
*/
app.controller('AsideCtrl', function ($scope, $aside) {
    $scope.openAside = function (position) {
        $aside.open({
            templateUrl: 'asideContent.html',
            placement: position,
            size: 'sm',
            backdrop: true,
            controller: function ($scope, $modalInstance) {
                $scope.ok = function (e) {
                    $modalInstance.close();
                    e.stopPropagation();
                };
                $scope.cancel = function (e) {
                    $modalInstance.dismiss();
                    e.stopPropagation();
                };
            }
        });
    };
});