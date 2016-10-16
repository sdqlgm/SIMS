'use strict';

/**
 * Config for the router
 */
app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$controllerProvider', '$compileProvider', '$filterProvider', '$provide', '$ocLazyLoadProvider', '$httpProvider', 'JS_REQUIRES',
function ($stateProvider, $urlRouterProvider, $locationProvider, $controllerProvider, $compileProvider, $filterProvider, $provide, $ocLazyLoadProvider, $httpProvider, jsRequires) {
    app.controller = $controllerProvider.register;
    app.directive = $compileProvider.directive;
    app.filter = $filterProvider.register;
    app.factory = $provide.factory;
    app.service = $provide.service;
    app.constant = $provide.constant;
    app.value = $provide.value;
    
    // Disable IE ajax request caching
    var getConfig = 
        {   'Cache-Control':'no-cache',
            'Pragma':'no-cache'
        };
    $httpProvider.defaults.headers['get'] = getConfig
    
    // LAZY MODULES

    $ocLazyLoadProvider.config({
        debug: false,
        events: true,
        modules: jsRequires.modules
    });

    // APPLICATION ROUTES
    // -----------------------------------
    // For any unmatched url, redirect to /app/dashboard
    $urlRouterProvider.otherwise("/app/assetManagement/studentManage?schoolId=-1&classesId=0&grade=-1");
    //
    // Set up the states
    $stateProvider.state('app', {
        url: "/app",
        templateUrl: "assets/views/app.html",
        resolve: loadSequence('queryClassManageController','classManageService','modernizr', 'moment', 'angularMoment', 'uiSwitch', 'perfect-scrollbar-plugin', 'perfect_scrollbar', 'toaster', 'ngAside', 'vAccordion', 'sweet-alert', 'chartjs', 'tc.chartjs', 'oitozero.ngSweetAlert'),
        abstract: true
    })
    
//***********************资产管理********************************//
    .state('app.assetManagement', {
        url: '/assetManagement',
        template: '<div ui-view class="fade-in-up"></div>',
        title: '学生管理',
        ncyBreadcrumb: {
            label: '学生管理'
        }
    })
    //学生信息
    .state('app.assetManagement.studentManage', {
    	url: '/studentManage?schoolId&classesId&grade',
        templateUrl: "assets/views/assetManagement/studentManage/studentManage.html",
        title: '学生管理',
        ncyBreadcrumb: {
            label: '学生管理'
        },
        resolve: loadSequence('select2CssCtrl','select2Ctrl','select2JsCtrl','queryStudentManageController','updateStudentManageController','addStudentManageController','studentManageService')
    })
//***********************demo********************************//    
    .state('app.demo', {
        url: '/demo',
        template: '<div ui-view class="fade-in-up"></div>',
        title: 'Demo',
        ncyBreadcrumb: {
            label: 'Demo'
        }
    }).state('app.demo.modal', {
        url: '/modal',
        templateUrl: "assets/views/demo/modal.html",
        title: '模态框',
        ncyBreadcrumb: {
            label: '模态框'
        },
        resolve: loadSequence('demoModalCtrl','select2CssCtrl','select2Ctrl','select2JsCtrl')
    }).state('app.demo.notification', {
        url: '/Notifications',
        templateUrl: "assets/views/demo/notification.html",
        title: '通知',
        ncyBreadcrumb: {
            label: '通知'
        },
        resolve: loadSequence('mapInit','mainCss','demoNotificationCtrl')
    }).state('app.demo.dateTime', {
        url: '/dateTime',
        templateUrl: "assets/views/demo/dateTime.html",
        title: '时间',
        ncyBreadcrumb: {
            label: '时间'
        },
        resolve: loadSequence('dateTimeCtrl')
    })
 
   .state('error.404', {
        url: '/404',
        templateUrl: "assets/views/utility_404.html",
    }).state('error.500', {
        url: '/500',
        templateUrl: "assets/views/utility_500.html",
    })

    // Generates a resolve object previously configured in constant.JS_REQUIRES (config.constant.js)
    function loadSequence() {
        var _args = arguments;
        return {
            deps: ['$ocLazyLoad', '$q',
			function ($ocLL, $q) {
			    var promise = $q.when(1);
			    for (var i = 0, len = _args.length; i < len; i++) {
			        promise = promiseThen(_args[i]);
			    }
			    return promise;

			    function promiseThen(_arg) {
			        if (typeof _arg == 'function')
			            return promise.then(_arg);
			        else
			            return promise.then(function () {
			                var nowLoad = requiredData(_arg);
			                if (!nowLoad)
			                    return $.error('Route resolve: Bad resource name [' + _arg + ']');
			                return $ocLL.load(nowLoad);
			            });
			    }

			    function requiredData(name) {
			        if (jsRequires.modules)
			            for (var m in jsRequires.modules)
			                if (jsRequires.modules[m].name && jsRequires.modules[m].name === name)
			                    return jsRequires.modules[m];
			        return jsRequires.scripts && jsRequires.scripts[name];
			    }
			}]
        };
    }
}]);