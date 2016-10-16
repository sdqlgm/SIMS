app.factory("classManageService", [ "$http", function($http) {
	// 带参数查询所有
	function query(params, success, error) {
		var dataUrl = "/sims/service/navInfo/query";
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
		query : query
	}
} ])