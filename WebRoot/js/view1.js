/**
 * 
 */
'use strict';

angular.module('AppStore.view1', ['ngRoute'])
.config(['$routeProvider', function($routeProvider) {
	$routeProvider.when('/app', {
		templateUrl:'htmls/state1.html',
		controller:'view1Ctrl'
	})
	.when('/detail', {
		templateUrl:'htmls/appDetail.html',
		controller:'detailCtrl'
	});
	
}])



.controller('view1Ctrl', ['$scope', '$http', 'AppInfo', function($scope, $http, AppInfo){
	$http({
		method: 'GET',
		url: 'app'
	}).then(function success(response){
		$scope.message = response;
		$scope.appInfos = response.data;
	});
	

	$scope.getRowNo = function(No){
		$scope.curAppInfo = $scope.appInfos[No];
		AppInfo.addAppInfo($scope.curAppInfo);
	};
}])

.controller('detailCtrl', ['$scope', '$http', 'AppInfo', function($scope, $http, AppInfo) {
	$scope.curAppInfo = AppInfo.getAppInfo();
	 $http({
	       method: 'POST',
	       url: 'similarApp',
	       data: $scope.curAppInfo
	})
	.then(function success(res) {
		$scope.recApps = res.data;
	});
}])

.service('AppInfo', function() {
	var appInfo = {};
	var addAppInfo = function(obj) {
		appInfo = obj;
	};
	var getAppInfo = function() {
		return appInfo;
	};
	
	return {
		addAppInfo: addAppInfo,
		getAppInfo: getAppInfo
	};
});