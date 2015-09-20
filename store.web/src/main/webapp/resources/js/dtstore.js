/**
 * 
 */
var app = angular.module('dtstore', []);
var path = window.location.pathname;
var producPath = "products/shopping/p?code=";
var productBuyUrl = ('#' + path + producPath);
var productId;

app.controller('ProductController',  function($scope, $http) {
	//url dos produtos
    $scope.productUrl = (producPath);
});


//app.controller('EventController',  function($scope, $http) {
//	  /*
//	   * expose the event object to the scope
//	   */
//	  $scope.clickMe = function(clickEvent) {
//		  $http.get(path + 'products/shopping').
//		  then(function(response) {
//		  	$scope.mostsoldlist = response.data;
//		  	//data = response;
//		  	
//		  }, function(response) {
//		  	alert('Erro');
//		  });
//	  };
//});
