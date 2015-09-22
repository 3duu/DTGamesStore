/**
 * 
 */
var app = angular.module('dtstore', []);
var path = window.location.pathname;
var producPath = "products/p?code=";
var shoppingPath = "shopping/additem";
var productBuyUrl = ('#' + path + producPath);
var productId;
var token = '';

app.controller('ProductController',  function($scope, $http) {
	//url dos produtos
    $scope.productUrl = producPath;
    
      var productId = 1;
      
	  $scope.addToCart = function(clickEvent) {
		  $http.post(shoppingPath, productId).
		  then(function(response) {
		  	//$scope.mostsoldlist = response.data;
		  	
		  }, function(response) {
		  	alert('Erro');
		  });
	};
    
    
  //Verificar carrinho de compras
    var userId = 1;
    
//    $http({	
//	    url: 'shopping/cartinfo', 
//	    method: "GET",
//	    params: {userId: userId}
//	 })
//	 .then(function(response) {
//    	$scope.cartItems = response.data.count;
//    	$scope.$apply();
//    }, function(response) {
//    	alert('Erro ao obter dados');
//    });
    
    
});

app.controller('UserController',  function($scope, $http) {
	
	//var element = angular.element('<div id="loading" class="loading">' + '<img src="../styling/img/loading.gif" alt="loading .... ">' + '</div>');
	var userId = 1;
	$scope.userUrl = '#';
	$http({	
	    url: 'user/data', 
	    method: "GET",
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
    		
    		//element.remove();
    	}
    		
    	$scope.account = response.data;
    }, function(response) {
    	alert('Impossível validar sessão');
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
