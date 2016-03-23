/**
 * 
 */

var urls = 
{
		cartInfo: 'cartinfo',
		shoppingPath: 'shopping/additem',
};

var app = angular.module('dtstore', []);
var path = window.location.pathname;
var productId;
var token = '';


app.controller('UserController',  function($scope, $http) {
	
	var userId = 1;
	$scope.userUrl = '#';
	//$scope.cartUrl = shoppingCartPath;
	var homeLink = angular.element('#urlBase').attr('href');
	
	$http({
	    url: homeLink + '/user/data', 
	    method: 'GET',
	    params: {userId: userId, sessionToken: token }
	 })
	 .then(function(response) {
    	
    	if(response.data.name != ''){
    		$('#loginLink').remove();
    		$scope.account = 'Minha conta';
    	}
    	else{
    		$scope.account = 'Fazer Login';
    		$('#userDropdown').remove();
    	}
    		
    	$scope.account = response.data;
    }, function(response) {
    	//alert('Impossível validar sessão');
    	$scope.account = 'Fazer Login';
    	$('#userDropdown').remove();
    	//element.remove();
    });
    
	//$scope.$apply()
	
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

//core da loja
var dtCORE = {
		parameters : {},
		map        : {},
		
		//functions
		isEmpty: function(variable){
			if(variable != null && variable != undefined && variable != 0 && variable != ''){
				return false;
			}
			return true;
		}
};