/**
 * 
 */
app.controller('dateTimeController', [ '$scope','$filter', function($scope,$filter) {

    //        $scope.format = 'yyyy-MM-dd HH:mm:ss';

    $scope.clear = function() {
        $scope.dt = null;
    };

    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened = !$scope.opened;
        console.log($filter('date')($scope.dt,'yyyy-MM-dd'));
    };

    $scope.dateOptions = {
        //              shortcutPropagation: true, 
        monthColumns : 12,
        showWeeks : false,
        startingDay : 1
    };
    
}]);