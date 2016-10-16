'use strict';
/**
 * controller for xeditable
 */

app.controller('TextsimspleCtrl', function ($scope) {
    $scope.example = {
        name: 'awesome user'
    };
});
app.controller('SelectLocalCtrl', function ($scope, $filter) {
    $scope.example = {
        status: 2
    };

    $scope.statuses = [{
        value: 1,
        text: 'status1'
    }, {
        value: 2,
        text: 'status2'
    }, {
        value: 3,
        text: 'status3'
    }, {
        value: 4,
        text: 'status4'
    }];

    $scope.showStatus = function () {
        var selected = $filter('filter')($scope.statuses, {
            value: $scope.example.status
        });
        return ($scope.example.status && selected.length) ? selected[0].text : 'Not set';
    };
});
app.controller('TextareaCtrl', function ($scope) {
    $scope.example = {
        desc: 'Awesome user \ndescription!'
    };
});
app.controller('SelectRemoteCtrl', function ($scope, $filter, $http) {
    $scope.example = {
        group: 4,
        groupName: 'admin' // original value
    };

    $scope.groups = [];

    $scope.loadGroups = function () {
        return $scope.groups.length ? null : $http.get('assets/api/groups.js').success(function (data) {
            $scope.groups = data.groups;
        });
    };

    $scope.$watch('example.group', function (newVal, oldVal) {
        if (newVal !== oldVal) {
            var selected = $filter('filter')($scope.groups, {
                id: $scope.example.group
            });
            $scope.example.groupName = selected.length ? selected[0].text : null;
        }
    });
});
app.controller('CheckboxCtrl', function ($scope) {
    $scope.example = {
        remember: true
    };
});
app.controller('ChecklistCtrl', function ($scope, $filter) {
    $scope.example = {
        status: [2, 3]
    };

    $scope.statuses = [{
        value: 1,
        text: 'status1'
    }, {
        value: 2,
        text: 'status2'
    }, {
        value: 3,
        text: 'status3'
    }];

    $scope.showStatus = function () {
        var selected = [];
        angular.forEach($scope.statuses, function (s) {
            if ($scope.example.status.indexOf(s.value) >= 0) {
                selected.push(s.text);
            }
        });
        return selected.length ? selected.join(', ') : 'Not set';
    };

});
app.controller('RadiolistCtrl', function ($scope, $filter) {
    $scope.example = {
        status: 2
    };

    $scope.statuses = [{
        value: 1,
        text: 'status1'
    }, {
        value: 2,
        text: 'status2'
    }];

    $scope.showStatus = function () {
        var selected = $filter('filter')($scope.statuses, {
            value: $scope.example.status
        });
        return ($scope.example.status && selected.length) ? selected[0].text : 'Not set';
    };
});
app.controller('BsdateCtrl', function ($scope) {
    $scope.example = {
        dob: new Date(1984, 4, 15)
    };
});
app.controller('TypeaheadCtrl', function ($scope) {
    $scope.user = {
        state: 'Arizona'
    };

    $scope.states = ['Alabama', 'Alaska', 'Arizona', 'Arkansas', 'California', 'Colorado', 'Connecticut', 'Delaware', 'Florida', 'Georgia', 'Hawaii', 'Idaho', 'Illinois', 'Indiana', 'Iowa', 'Kansas', 'Kentucky', 'Louisiana', 'Maine', 'Maryland', 'Massachusetts', 'Michigan', 'Minnesota', 'Mississippi', 'Missouri', 'Montana', 'Nebraska', 'Nevada', 'New Hampshire', 'New Jersey', 'New Mexico', 'New York', 'North Dakota', 'North Carolina', 'Ohio', 'Oklahoma', 'Oregon', 'Pennsylvania', 'Rhode Island', 'South Carolina', 'South Dakota', 'Tennessee', 'Texas', 'Utah', 'Vermont', 'Virginia', 'Washington', 'West Virginia', 'Wisconsin', 'Wyoming'];
});
app.controller('TextCustomizeCtrl', function ($scope) {
    $scope.user = {
        name: 'awesome user'
    };
});
app.controller('TextBtnCtrl', function ($scope) {
    $scope.user = {
        name: 'awesome user'
    };
    app.controller('SelectNobuttonsCtrl', function ($scope, $filter) {
        $scope.user = {
            status: 2
        };

        $scope.statuses = [{
            value: 1,
            text: 'status1'
        }, {
            value: 2,
            text: 'status2'
        }, {
            value: 3,
            text: 'status3'
        }, {
            value: 4,
            text: 'status4'
        }];

        $scope.showStatus = function () {
            var selected = $filter('filter')($scope.statuses, {
                value: $scope.user.status
            });
            return ($scope.user.status && selected.length) ? selected[0].text : 'Not set';
        };
    });
    app.controller('SelectMultipleCtrl', function ($scope, $filter) {
        $scope.user = {
            status: [2, 4]
        };

        $scope.statuses = [{
            value: 1,
            text: 'status1'
        }, {
            value: 2,
            text: 'status2'
        }, {
            value: 3,
            text: 'status3'
        }, {
            value: 4,
            text: 'status4'
        }];

        $scope.showStatus = function () {
            var selected = [];
            angular.forEach($scope.statuses, function (s) {
                if ($scope.user.status.indexOf(s.value) >= 0) {
                    selected.push(s.text);
                }
            });
            return selected.length ? selected.join(', ') : 'Not set';
        };
    });
});