app.factory("studentManageService", [ "$http", function($http) {
	// 带参数查询所有
	function query(params, success, error) {
		var dataUrl = "/sims/service/studentInfo/query";
		$http({
			url : dataUrl,
			method : "GET",
			params : params
		}).success(function(data) {
			success(data);
		}).error(function(data) {
			error(data)
		});
	}
	
	// 查询某个班级的信息
	function queryClasses(params, success, error) {
		var dataUrl = "/sims/service/classesInfo/queryByClassesId";
		$http({
			url : dataUrl,
			method : "GET",
			params : params
		}).success(function(data) {
			success(data);
		}).error(function(data) {
			error(data)
		});
	}

	// 新增学生基本信息
	function addStudentInfo(params, success, error) {
		var dataUrl = "/sims/service/studentInfo/addStudentInfo";
		$http({
			url : dataUrl,
			method : "GET",
			params : params
		}).success(function(data) {
			success(data);
		}).error(function(data) {
			error(data)
		});
	}

	// 删除学生基本信息
	function deleteStudentInfo(params, success, error) {
		var dataUrl = "/sims/service/studentInfo/deleteStudentInfo";
		$http({
			url : dataUrl,
			method : "GET",
			params : params
		}).success(function(data) {
			success(data);
		}).error(function(data) {
			error(data)
		});
	}

	// 修改学生基本信息
	function updateStudentInfo(params, success, error) {
		var dataUrl = "/sims/service/studentInfo/updateStudentInfo";
		$http({
			url : dataUrl,
			method : "GET",
			params : params
		}).success(function(data) {
			success(data);
		}).error(function(data) {
			error(data)
		});
	}
	return {
		query : query,
		queryClasses : queryClasses,
		addStudentInfo : addStudentInfo,
		deleteStudentInfo : deleteStudentInfo,
		updateStudentInfo : updateStudentInfo
	}
} ])