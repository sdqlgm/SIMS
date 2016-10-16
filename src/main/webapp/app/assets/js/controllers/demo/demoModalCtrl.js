/**
 * 
 */
app.controller('modalDemoCtrl', [ '$scope', '$modal', '$log', function($scope, $modal, $log) {

    $scope.items = [ 'item1', 'item2', 'item3' ];

    $scope.open = function(size) {
        var modalInstance = $modal.open({
            templateUrl : 'assets/views/demo/modalContent.html',
            controller : 'modalInstanceCtrl1',
            cache:false,
            size : size,
            resolve : {
                items : function() {
                    return $scope.items;
                }
            }
        });

        modalInstance.result.then(function(selectedItem) {
            $scope.selected = selectedItem;
        }, function() {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };
    

    $("#areaCode").select2({
        ajax : {
            url : "/sims/service/roadInfo/areaCode",// 根据道路中的地区加载
            dataType : 'json',
            delay : 250,
            data : function(params) {
                return {
                    areaName : params.term,
                };
            },
            processResults : function(data) {
                var result = data.messageBody.list;
                var temps = [];
                if (result != undefined) {
                    for (var i = 0; i < result.length; i++) {
                        var tempV = {
                            id : result[i].id, // 名称
                            text : result[i].areaName// 值
                        };
                        temps.push(tempV);
                    };
                };
                return {
                    results : temps,
                };
            },
            cache : true
        },
        escapeMarkup : function(markup) {
            return markup;
        },
        minimumInputLength : 1,
        templateResult : formatRepo,
        templateSelection : formatRepoSelection
    });
    function formatRepo(repo){return repo.text};
    function formatRepoSelection(repo){return repo.text}
} ]);

// Please note that $modalInstance represents a modal window (instance)
// dependency.
// It is not the same as the $modal service used above.

app.controller('modalInstanceCtrl1', [ '$scope', '$modalInstance', 'items', '$timeout', function($scope, $modalInstance, items, $timeout) {

    $scope.items = items;
    $scope.selected = {
        item : $scope.items[0]
    };
    
    
    $timeout(function () {
        $("#areaCode2").select2({
            ajax : {
                url : "/sims/service/roadInfo/areaCode",// 根据道路中的地区加载
                dataType : 'json',
                delay : 250,
                data : function(params) {
                    return {
                        areaName : params.term,
                    };
                },
                processResults : function(data) {
                    var result = data.messageBody.list;
                    var temps = [];
                    if (result != undefined) {
                        for (var i = 0; i < result.length; i++) {
                            var tempV = {
                                id : result[i].id, // 名称
                                text : result[i].areaName// 值
                            };
                            temps.push(tempV);
                        };
                    };
                    return {
                        results : temps,
                    };
                },
                cache : true
            },
            escapeMarkup : function(markup) {
                return markup;
            },
            minimumInputLength : 1,
            templateResult : formatRepo,
            templateSelection : formatRepoSelection
        });
        
    })
    function formatRepo(repo){return repo.text};
    function formatRepoSelection(repo){return repo.text}
    
    $scope.ok = function() {
        $modalInstance.close($scope.selected.item);
    };

    $scope.cancel = function() {
        $modalInstance.dismiss('cancel');
    };
} ]);