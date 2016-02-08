/**
 * 
 */
'use strict';

var App = angular.module('AppStore', ['ngRoute',
                                      'AppStore.view1']);

App.config(['$routeProvider', function($routeProvider) {
	$routeProvider.otherwise({
		redirectTo: '/app'
	});
}]);

/*App.controller('state1Ctrl', ['$scope', function($scope){
	$scope.message = '11asdfasdf';
	console.log($scope.message);
}]);*/