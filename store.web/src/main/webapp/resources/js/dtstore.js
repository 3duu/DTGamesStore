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
	
	$http({	
	    url: homeLink + '/shopping/cartcount', 
	    method: "GET"
	 })
	 .then(function(response) {
    	
    	if(response.data){
    		angular.element('#cartCount').text(response.data);
   		 	$scope.cartCount = response.data.length;
    	}
    		
    }, function(response) {
    	alert('Erro ao recuperar informações do carrinho')
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
		url: {home: angular.element('#urlBase').attr('href')},
		
		//functions
		isEmpty: function(variable){
			if(variable != null && variable != undefined && variable != 0 && variable != ''){
				return false;
			}
			return true;
		},
		pagination: {itemsPerPage: 10, doPaging:function(data){
			
				var returnData = [{}];
				var count = 0;
				var page = 0;
				for(var i=0;i<data.length;i++){
					returnData[page].push(data[i]);
					if(count > 5){
						page++;
						count = 0;
					}		
				}
			
				return returnData;
		}}
};