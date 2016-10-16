'use strict';
// Requires jQuery from http://jquery.com/
// and jQuerySparklines from http://omnipotent.net/jquery.sparkline

// AngularJS directives for jquery sparkline
angular.module('sparkline', []);
angular.module('sparkline').directive('jqSparkline', [
function() {'use strict';
	return {
		restrict: 'A',
		require: 'ngModel',
		link: function(scope, elem, attrs, ngModel) {
			var opts = {};
			//TODO: Use $eval to get the object
			opts.type = attrs.type || 'line';
			opts.barColor = attrs.barColor || '#000000';
			opts.height = attrs.height || '35px';
			opts.width = attrs.width || '35px';
			opts.barWidth = attrs.barWidth || '5px';
			opts.barSpacing = attrs.barSpacing || '2px';
			opts.zeroAxis = attrs.zeroAxis || 'true';
			opts.resize = attrs.resize || false;
			opts.fillColor = attrs.fillColor || '#cdf';
			opts.lineWidth = attrs.lineWidth || 1;
			opts.lineColor = attrs.lineColor || '#00f';
			opts.spotColor = attrs.spotColor || '#f80';
			opts.spotRadius = attrs.spotRadius || 1.5;
			opts.minSpotColor = attrs.minSpotColor || '#f80';
			opts.maxSpotColor = attrs.maxSpotColor || '#f80';
			opts.highlightSpotColor = attrs.highlightSpotColor || '#5f5';
			opts.highlightLineColor = attrs.highlightLineColor || '#f22';
			
			

			scope.$watch(attrs.ngModel, function() {
				render();
			});
			scope.$watch(attrs.opts, function() {
				render();
			});
			var render = function() {
				var model;
				if(attrs.opts)
					angular.extend(opts, angular.fromJson(attrs.opts));
				console.log(opts);
				// Trim trailing comma if we are a string
				angular.isString(ngModel.$viewValue) ? model = ngModel.$viewValue.replace(/(^,)|(,$)/g, "") : model = ngModel.$viewValue;
				var data;
				// Make sure we have an array of numbers
				angular.isArray(model) ? data = model : data = model.split(',');
				$(elem).sparkline(data, opts);
			};

			// function to initiate Sparkline
			var sparkResize;
			$(window).resize(function(e) {
				if (opts.resize) {
					clearTimeout(sparkResize);
					sparkResize = setTimeout(render, 500);
				}
			});
		}
	};
}]);
