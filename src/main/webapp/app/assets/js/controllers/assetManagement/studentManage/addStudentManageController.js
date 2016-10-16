app.controller('addStudentManageController', ['$scope','$location','$modal', '$log','$filter','studentManageService','SweetAlert',function($scope,$location,$modal, $log,$filter,studentManageService,SweetAlert) {
	//时间控件
    $scope.open = function($event) {
        $event.preventDefault();
        $event.stopPropagation();
        $scope.opened = !$scope.opened;
    };
    $scope.dateOptions = {
        monthColumns : 12,
        showWeeks : false,
        startingDay : 1
    };
	function formatRepo(repo){return repo.text};
	function formatRepoSelection(repo){return repo.text};
	//初始化新增参数,从URL中获取
	$scope.studentInfoModel = {};
	$scope.studentInfoModel.classesId = $location.search().classesId;
	$scope.studentInfoModel.schoolId = $location.search().schoolId;
	$scope.studentInfoModel.grade = $location.search().grade;
	//确定新增
    $scope.ok = function() {
    	if($scope.studentInfoModel.classesId <= 0||$scope.studentInfoModel.grade <= 0){
    		 SweetAlert.swal("录入失败!", "请先选择进入一个班级后再进行录入！", "error");
    		 return ;
    	}
    	$scope.studentInfoModel['birthday'] = $filter('date')($scope.studentInfoModel.birthday,'yyyy-MM-dd HH:mm:ss');		
    	studentManageService.addStudentInfo($scope.studentInfoModel,function (data) {
					if (data.state == 200) {
		            	 $scope.isok =  data.messageBody.isok;
		            	 if($scope.isok == true){
		            		//新增成功
		            		SweetAlert.swal("录入成功!", "您成功添加一条数据", "success");
		            		document.getElementById("insert").style.display="none";
		            		document.getElementById("insert1").style.display="";
		            		$scope.queryAddedInfo();
		            	 }
		            	 if($scope.isok == false){
		            		//失败的原因
		            		 SweetAlert.swal("录入失败!", "录入失败", "error");
		            	 }
					}
				}, function (err) {
			})
    };
    //新增完成后查询新增的信息
    $scope.queryAddedInfo = function () {
    	studentManageService.query({"studentId":$scope.studentInfoModel.studentId},function (data) {
            if (data.state == 200) {
            	$scope.studentAddedInfo = data.messageBody.studentInfo[0];
            }
        }, function (err) {
        })
    };
     $scope.reset = function(){
		// $scope.studentInfoModel = {};
		 $scope.studentAddedInfo = {};
	 };
	 $scope.next = function(){
		// $scope.studentInfoModel = {};
		 $scope.studentAddedInfo = {};
		 document.getElementById("insert").style.display="";
		 document.getElementById("insert1").style.display="none";
	 };	
	
} ]);
