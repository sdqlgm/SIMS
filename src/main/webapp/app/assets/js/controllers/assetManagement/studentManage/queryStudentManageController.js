app.controller('queryStudentManageController', ['$scope','$location','$modal', '$log','$filter','studentManageService','SweetAlert',function($scope,$location,$modal, $log,$filter,studentManageService,SweetAlert) {
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
    
    //动态加载搜索数据--学号
	$("#studentId").select2({
		  ajax: {
		    url: "/sims/service/studentInfo/queryDynamic", //路径
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		      return {
		    	  paramName:"studentId",
		    	  value: params.term, //参数
		    	  classesId: $location.search().classesId
		      };
		    },
		 processResults: function (data) {
			 var result = data.messageBody.list;
			 var temps= [];
			 if(result != undefined){
				for(var i=0;i<result.length;i++){
					var tempV = {
			 			id: result[i].studentId,  //名称 key
			 			text: result[i].studentId //值 value
				    	};
					temps.push(tempV);
				};
			 }
		   return {
		    	results: temps,
		     };
		    },
		    cache: true
		   },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection 
		});
	//动态加载搜索数据--姓名
	$("#name").select2({
		  ajax: {
		    url: "/sims/service/studentInfo/queryDynamic", //路径
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		      return {
		    	  paramName:"name",
		    	  value: params.term, //参数
		    	  classesId: $location.search().classesId
		      };
		    },
		 processResults: function (data) {
			 var result = data.messageBody.list;
			 var temps= [];
			 if(result != undefined){
				for(var i=0;i<result.length;i++){
					var tempV = {
			 			id: result[i].name,  //名称 key
			 			text: result[i].name //值 value
				    	};
					temps.push(tempV);
				};
			 }
		   return {
		    	results: temps,
		     };
		    },
		    cache: true
		   },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection 
		});
	//动态加载搜索数据--身份证号
	$("#citizenId").select2({
		  ajax: {
		    url: "/sims/service/studentInfo/queryDynamic", //路径
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		      return {
		    	  paramName:"citizenId",
		    	  value: params.term, //参数
		    	  classesId: $location.search().classesId
		      };
		    },
		 processResults: function (data) {
			 var result = data.messageBody.list;
			 var temps= [];
			 if(result != undefined){
				for(var i=0;i<result.length;i++){
					var tempV = {
			 			id: result[i].citizenId,  //名称 key
			 			text: result[i].citizenId //值 value
				    	};
					temps.push(tempV);
				};
			 }
		   return {
		    	results: temps,
		     };
		    },
		    cache: true
		   },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection 
		});
	//动态加载搜索数据--地址
	$("#address").select2({
		  ajax: {
		    url: "/sims/service/studentInfo/queryDynamic", //路径
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		      return {
		    	  paramName:"address",
		    	  value: params.term, //参数
		    	  classesId: $location.search().classesId
		      };
		    },
		 processResults: function (data) {
			 var result = data.messageBody.list;
			 var temps= [];
			 if(result != undefined){
				for(var i=0;i<result.length;i++){
					var tempV = {
			 			id: result[i].address,  //名称 key
			 			text: result[i].address //值 value
				    	};
					temps.push(tempV);
				};
			 }
		   return {
		    	results: temps,
		     };
		    },
		    cache: true
		   },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection 
		});
	//动态加载搜索数据--政治面貌
	$("#politicalStatus").select2({
		  ajax: {
		    url: "/sims/service/studentInfo/queryDynamic", //路径
		    dataType: 'json',
		    delay: 250,
		    data: function (params) {
		      return {
		    	  paramName:"politicalStatus",
		    	  value: params.term, //参数
		    	  classesId: $location.search().classesId
		      };
		    },
		 processResults: function (data) {
			 var result = data.messageBody.list;
			 var temps= [];
			 if(result != undefined){
				for(var i=0;i<result.length;i++){
					var tempV = {
			 			id: result[i].politicalStatus,  //名称 key
			 			text: result[i].politicalStatus //值 value
				    	};
					temps.push(tempV);
				};
			 }
		   return {
		    	results: temps,
		     };
		    },
		    cache: true
		   },
		  escapeMarkup: function (markup) { return markup; }, 
		  minimumInputLength: 1,
		  templateResult: formatRepo, 
		  templateSelection: formatRepoSelection 
		});
	
	
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
    	//获取父页面传过来的班级ID
    	if($location.search().classesId > 0){
    		$scope.queryConditionData.classesId = $location.search().classesId;
    	}
    	
    	//查询班级所有学生
    	studentManageService.query($scope.queryConditionData,function (data) {
            if (data.state == 200) {
            	$scope.studentInfo = data.messageBody.studentInfo;
            	$scope.totalItems = data.messageBody.total;
            	$scope.currentPage = data.messageBody.currentPage;
            	$scope.pages = data.messageBody.pages;
            }
        }, function (err) {
        });
        
        //查询班级信息
    	if($location.search().classesId > 0){
	        studentManageService.queryClasses($scope.queryConditionData,function (data) {
	            if (data.state == 200) {
	            	$scope.classesInfo = data.messageBody.classesInfo;
	            }
	        }, function (err) {
	        })
    	}else{
    		//首次展示全部学生
    		$scope.classesInfo = {};
    		$scope.classesInfo.name = "全部班级";
    		$scope.classesInfo.grade = "全部年级";
    		$scope.classesInfo.teacher = "无";
    	}
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
	$scope.updateStudentInfo = function(data) {
		$scope.data = data;
		var modalInstance = $modal.open({
			templateUrl : 'assets/views/assetManagement/studentManage/updateStudentManage.html',
			controller : 'updateStudentManageController',
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
	$scope.deleteStudentInfo = function(studentId) {
		$scope.queryConditionData = {};
		$scope.queryConditionData.studentId = studentId;
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
            	studentManageService.deleteStudentInfo($scope.queryConditionData,function (data) {
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