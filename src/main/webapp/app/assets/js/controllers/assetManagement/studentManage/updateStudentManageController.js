//修改
app.controller('updateStudentManageController', [
		'$scope',
		'$filter',
		'$log',
		'$modal',
		'$modalInstance',
		'SweetAlert',
		'data1',
		'studentManageService',
		function($scope, $filter, $log, $modal, $modalInstance, SweetAlert,
				data1, studentManageService) {
			$scope.studentModel = data1;
			$scope.studentModel['createDate'] = $filter('date')(
					$scope.studentModel.createDate, 'yyyy-MM-dd HH:mm:ss');
			// 时间控件
			$scope.open = function($event) {
				$event.preventDefault();
				$event.stopPropagation();
				$scope.opened = !$scope.opened;
			};
			$scope.dateOptions = {
				// shortcutPropagation: true,
				monthColumns : 12,
				showWeeks : false,
				startingDay : 1
			};
			function formatRepo(repo) {
				return repo.text
			}
			;
			function formatRepoSelection(repo) {
				return repo.text
			}
			;
			// 确定
			$scope.ok = function() {
				// 修改
				$scope.studentModel['birthday'] = $filter('date')(
						$scope.studentModel.birthday.time, 'yyyy-MM-dd');
				studentManageService.updateStudentInfo($scope.studentModel,
						function(data) {
							if (data.state == 200) {
								$scope.isok = data.messageBody.isok;
								if ($scope.isok ==true) {
									// 修改成功
									$modalInstance.close("OK");
								}else{
									SweetAlert.swal("修改失败!", "修改失败！", "error");
								}
							}
						}, function(err) {
						})
			};
			$scope.cancel = function() {
				$modalInstance.dismiss('cancel');
			};
		} ]);