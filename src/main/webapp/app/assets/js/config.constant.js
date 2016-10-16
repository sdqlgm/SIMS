'use strict';

/**
 * Config constant
 */
app.constant('APP_MEDIAQUERY', {
    'desktopXL': 1200,
    'desktop': 992,
    'tablet': 768,
    'mobile': 480
});
app.constant('JS_REQUIRES', {
    //*** Scripts
    scripts: {
        //*** Javascript Plugins
        'modernizr': ['vendor/modernizr/modernizr.js'],
        'moment': ['vendor/moment/moment.min.js'],
        'spin': 'vendor/ladda/spin.min.js',

        //*** jQuery Plugins
        'perfect-scrollbar-plugin': ['vendor/perfect-scrollbar/perfect-scrollbar.min.js', 'vendor/perfect-scrollbar/perfect-scrollbar.min.css'],
        'ladda': ['vendor/ladda/spin.min.js', 'vendor/ladda/ladda.min.js', 'vendor/ladda/ladda-themeless.min.css'],
        'sweet-alert': ['vendor/sweet-alert/sweet-alert.min.js', 'vendor/sweet-alert/sweet-alert.css'],
        'chartjs': 'vendor/chartjs/Chart.min.js',
        'jquery-sparkline': 'vendor/sparkline/jquery.sparkline.min.js',
        'ckeditor-plugin': 'vendor/ckeditor/ckeditor.js',
        'jquery-nestable-plugin': ['vendor/ng-nestable/jquery.nestable.js', 'vendor/ng-nestable/jquery.nestable.css'],
        'touchspin-plugin': 'vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.js',

        //***select2
        'select2CssCtrl': 'vendor/select2/css/select2.min.css',
        'select2JsCtrl': 'vendor/select2/js/select2.full.js',
        'select2Ctrl': 'vendor/select2/js/select2.js',
        
        
        //***********************资产管理********************************//
        
        //班级管理
        'queryClassManageController': 'assets/js/controllers/assetManagement/classManage/queryClassManageController.js',
        'classManageService': 'assets/js/controllers/assetManagement/classManage/classManageService.js',
        
        //学生信息
        'queryStudentManageController': 'assets/js/controllers/assetManagement/studentManage/queryStudentManageController.js',
        'updateStudentManageController': 'assets/js/controllers/assetManagement/studentManage/updateStudentManageController.js',
        'addStudentManageController': 'assets/js/controllers/assetManagement/studentManage/addStudentManageController.js',
        'studentManageService': 'assets/js/controllers/assetManagement/studentManage/studentManageService.js',
        
        //基站管理
        'queryBaseStationManageController': 'assets/js/controllers/assetManagement/baseStationManage/queryBaseStationManageController.js',
        'updateBaseStationManageController': 'assets/js/controllers/assetManagement/baseStationManage/updateBaseStationManageController.js',
        'addBaseStationManageController': 'assets/js/controllers/assetManagement/baseStationManage/addBaseStationManageController.js',
        'baseStationManageService': 'assets/js/controllers/assetManagement/baseStationManage/baseStationManageService.js',
        
        //读卡器管理
//        'readerManageCtrl': 'assets/js/controllers/assetManagement/readerManage/readerManageController.js',
//        'readerManageService': 'assets/js/controllers/assetManagement/readerManage/readerManageService.js',
        
        //天线管理
        'queryAntennaManageController':'assets/js/controllers/assetManagement/antennaManage/queryAntennaManageController.js',
        'updateAntennaManageController':'assets/js/controllers/assetManagement/antennaManage/updateAntennaManageController.js',
        'addAntennaManageController':'assets/js/controllers/assetManagement/antennaManage/addAntennaManageController.js',
        'antennaManageService': 'assets/js/controllers/assetManagement/antennaManage/antennaManageService.js',
       
        //道路管理
        'queryRoadManageController':'assets/js/controllers/assetManagement/roadManage/queryRoadManageController.js',
        'updateRoadManageController':'assets/js/controllers/assetManagement/roadManage/updateRoadManageController.js',
        'addRoadManageController':'assets/js/controllers/assetManagement/roadManage/addRoadManageController.js',
        'roadManageService': 'assets/js/controllers/assetManagement/roadManage/roadManageService.js',
	//系统设置-->基站类型
        'baseStationManageTypeController':'assets/js/controllers/systemConfig/baseStationManageTypeController.js',
        'baseStationManageTypeService':'assets/js/controllers/systemConfig/baseStationManageTypeService.js',
       
       
        
        //***********************Demo********************************//
        'dashboardCtrl': 'assets/js/controllers/dashboardCtrl.js',
        'demoModalCtrl': 'assets/js/controllers/demo/demoModalCtrl.js',
        'demoNotificationCtrl': 'assets/js/controllers/demo/demoNotificationCtrl.js',
        'dateTimeCtrl': 'assets/js/controllers/demo/dateTimeCtrl.js',
        
        
        
        //*** Filters
        'htmlToPlaintext': 'assets/js/filters/htmlToPlaintext.js'
    },
    
    //*** angularJS Modules
    modules: [{
        name: 'angularMoment',
        files: ['vendor/moment/angular-moment.min.js']
    }, {
        name: 'perfect_scrollbar',
        files: ['vendor/perfect-scrollbar/angular-perfect-scrollbar.js']
    }, {
        name: 'toaster',
        files: ['vendor/toaster/toaster.js', 'vendor/toaster/toaster.css']
    }, {
        name: 'angularBootstrapNavTree',
        files: ['vendor/angular-bootstrap-nav-tree/abn_tree_directive.js', 'vendor/angular-bootstrap-nav-tree/abn_tree.css']
    }, {
        name: 'angular-ladda',
        files: ['vendor/ladda/angular-ladda.min.js']
    }, {
        name: 'ngTable',
        files: ['vendor/ng-table/ng-table.min.js', 'vendor/ng-table/ng-table.min.css']
    }, {
        name: 'ui.select',
        files: ['vendor/ui-select/select.min.js', 'vendor/ui-select/select.min.css', 'vendor/ui-select/select2.css', 'vendor/ui-select/select2-bootstrap.css', 'vendor/ui-select/selectize.bootstrap3.css']
    }, {
        name: 'ui.mask',
        files: ['vendor/ui-utils/mask/mask.js']
    }, {
        name: 'angular-bootstrap-touchspin',
        files: ['vendor/bootstrap-touchspin/angular.bootstrap-touchspin.js', 'vendor/bootstrap-touchspin/jquery.bootstrap-touchspin.min.css']
    }, {
        name: 'ngImgCrop',
        files: ['vendor/ngImgCrop/ng-img-crop.js', 'vendor/ngImgCrop/ng-img-crop.css']
    }, {
        name: 'angularFileUpload',
        files: ['vendor/angular-file-upload/angular-file-upload.min.js', 'vendor/angular-file-upload/directives.js']
    }, {
        name: 'ngAside',
        files: ['vendor/angular-aside/angular-aside.min.js', 'vendor/angular-aside/angular-aside.min.css']
    }, {
        name: 'truncate',
        files: ['vendor/angular-truncate/truncate.js']
    }, {
        name: 'oitozero.ngSweetAlert',
        files: ['vendor/sweet-alert/ngSweetAlert.min.js']
    }, {
        name: 'monospaced.elastic',
        files: ['vendor/angular-elastic/elastic.js']
    }, {
        name: 'ngMap',
        files: ['vendor/angular-google-maps/ng-map.min.js']
    }, {
        name: 'tc.chartjs',
        files: ['vendor/chartjs/tc-angular-chartjs.min.js']
    }, {
        name: 'sparkline',
        files: ['vendor/sparkline/angular-sparkline.js']
    }, {
        name: 'flow',
        files: ['vendor/ng-flow/ng-flow-standalone.min.js']
    }, {
        name: 'uiSwitch',
        files: ['vendor/angular-ui-switch/angular-ui-switch.min.js', 'vendor/angular-ui-switch/angular-ui-switch.min.css']
    }, {
        name: 'ckeditor',
        files: ['vendor/ckeditor/angular-ckeditor.min.js']
    }, {
        name: 'mwl.calendar',
        files: ['vendor/angular-bootstrap-calendar/angular-bootstrap-calendar.js', 'vendor/angular-bootstrap-calendar/angular-bootstrap-calendar-tpls.js', 'vendor/angular-bootstrap-calendar/angular-bootstrap-calendar.min.css']
    }, {
        name: 'ng-nestable',
        files: ['vendor/ng-nestable/angular-nestable.js']
    }, {
        name: 'vAccordion',
        files: ['vendor/v-accordion/v-accordion.min.js', 'vendor/v-accordion/v-accordion.min.css']
    }, {
        name: 'xeditable',
        files: ['vendor/angular-xeditable/xeditable.min.js', 'vendor/angular-xeditable/xeditable.css']
    }, {
        name: 'config-xeditable',
        files: ['vendor/angular-xeditable/config-xeditable.js']
    }, {
        name: 'checklist-model',
        files: ['vendor/checklist-model/checklist-model.js']
    }]
});
