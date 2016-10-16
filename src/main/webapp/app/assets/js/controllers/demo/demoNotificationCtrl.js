/**
 * 
 */
app.controller('demoNotificationCtrl', [ '$scope', 'toaster', 'SweetAlert',
        function($scope, toaster, SweetAlert) {
	
		require(["common/ShareMap","dojo/domReady!"],function(ShareMap){
			
            $scope.demo3 = function() {
                SweetAlert.swal({
                    title: "操作成功!",
                    type: "success",
                    timer: 2000,
                    confirmButtonText: "确定"
                });
            };
            
            $scope.demo5 = function () {
                SweetAlert.swal({
                    title: "注意！",
                    text: "是否确定该操作",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    closeOnCancel: true
                }, function (isConfirm) {
                    if (isConfirm) {
                        console.log("确定");
                        SweetAlert.swal("Deleted!", "Your imaginary file has been deleted.", "success");
                    } else {
                        SweetAlert.swal("Cancelled", "Your imaginary file is safe :)", "error");
                    }
                });
            };
            
            $scope.toaster = {
                type : 'success',
                title : 'Title',
                text : 'Message'
            };
            $scope.pop = function() {
                toaster.pop($scope.toaster.type, $scope.toaster.title, $scope.toaster.text);
            };
            
            /***
             * 地图部分
             */
            var map,view;
        	var shareMap = new ShareMap();
        	//初始化地图
        	var result = shareMap._initMap("testMap",103.96993,30.4996166666667);
        	map =result.map;
        	view = result.view;
        	 //添加图层
            var graphicLayer =shareMap._addGraphicLayer(map,1);
            //添加点
            var graphic = shareMap._addPoint(graphicLayer,103.96993,30.4996166666667,0,[223,100,40],"red",5);
            //移除点
            shareMap._removePoint(graphicLayer,graphic);
            //添加picture点
            var graphic = shareMap._addPointPicture(graphicLayer,103.96993,30.4996166666667,0,"assets/images/abnormal.png","20px","20px");
            });
		
			/*view.on("click", sdd);
			var i = 1;
			
			function sdd(evt) {
				view.hitTest(evt.screenPoint).then(function(response) {
						var result = response.results[0];
						if (result) {
							var lon = result.mapPoint.longitude;
							var lat = result.mapPoint.latitude;
							console
									.log(
											"Hit surface at ("
													+ lon
													+ ", "
													+ lat
													+ "), graphic:",
											result.graphic
													|| "none");
						}
					});
			}*/
           
        } ]);