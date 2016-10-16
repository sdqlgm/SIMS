app.controller('queryClassManageController', ['$scope','$modal', '$log','$filter','classManageService','SweetAlert',function($scope,$modal, $log,$filter,classManageService,SweetAlert) {
	$scope.currentPage = 1;//初始化当前页
    $scope.pageSize = 10;//初始化每页大小
    $scope.queryConditionData = {};//初始化查询条件
    //时间控件
    $scope.open1 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened1 = !$scope.opened1;
    };
    $scope.open2 = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened2 = !$scope.opened2;
    };
    $scope.dateOptions1 = {
        //shortcutPropagation: true, 
        monthColumns : 12,
        showWeeks : false,
        startingDay : 1
    };
    $scope.dateOptions2 = {
        monthColumns : 12,
        showWeeks : false,
        startingDay : 1
    };
	
	
	function formatRepo(repo){return repo.text};
	function formatRepoSelection(repo){return repo.text}
    //翻页
    $scope.pageChanged = function () {
	   	//当前页
	   	$scope.queryConditionData['currentPage'] = $scope.currentPage;
	   	$scope.queryConditionData['pageSize'] = $scope.pageSize;
	   	$scope.query();
    };
    //浏览最大记录数
    $scope.pageQuery = function () {
	   	//当前页
	   	$scope.queryConditionData['currentPage'] = 1;
	   	$scope.queryConditionData['pageSize'] = $scope.pageSize;
	   	$scope.query();
    };
   //查询
    $scope.query = function () {
    	classManageService.query($scope.queryConditionData,function (data) {
            if (data.state == 200) {
            	$scope.navInfo = data.messageBody.navInfo;
            }
        }, function (err) {
        })
    };
	//重置
	$scope.reset = function(){
		var objs = $(".select2-selection__rendered");
		angular.forEach(objs, function(data,index,array){
			console.log($(data))
			if($(data).text() != "全部"){
				$(data).text("全部");
				$(data).val("");
				$(data).attr("title","全部");
			}
		});
		$scope.queryConditionData = {};
	};
	//初始化查询条件
	$scope.query();
	//修改
	$scope.updateClassInfo = function(data) {
		$scope.data = data;
		var modalInstance = $modal.open({
			templateUrl : 'assets/views/assetManagement/classManage/updateClassManage.html',
			controller : 'updateClassManageController',
			backdrop: 'static',
			keyboard: false,
			size : 'md',
			resolve : {
				data1 : function() {
					return $scope.data;
				}
			}
		});
		modalInstance.result.then(function(data) {
			$scope.isupdate = data;
			if($scope.isupdate == "OK"){
				 SweetAlert.swal("修改成功!", "您成功修改了一条数据", "success");
				 $scope.query(); 
			}
		}, function(err) {
		});
	};
	
	//删除
	$scope.deleteClassInfo = function(classId) {
		$scope.queryConditionData = {};
		$scope.queryConditionData.classId = classId;
		SweetAlert.swal({
            title: "注意！",
            text: "您确定要删除该学生信息吗？",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            closeOnConfirm: false,
            closeOnCancel: true
        }, function (isConfirm) {
            if (isConfirm) {
            	classManageService.deleteClassInfo($scope.queryConditionData,function (data) {
                    if (data.state == 200) {
                    	$scope.isdelete =  data.messageBody.isok;
            			if($scope.isdelete == true){
            				 SweetAlert.swal("删除成功!", "您成功删除了一条学生信息。", "success");
            				 $scope.queryConditionData = {};
            				 $scope.query();
            			}
            			if($scope.isdelete == false){
            				 SweetAlert.swal("删除失败!", "删除失败！", "error");
            			}
                    }
                }, function (err) {
                })
            } 
        });
	}
} ]);