/**
 * 
 */

var urls = 
{
		cartInfo: 'cartinfo',
		shoppingPath: 'shopping/additem'
};

var app = angular.module('dtstore', []);
var path = window.location.pathname;
var producPath = "products/p?code=";
var shoppingCartPath = "shopping/cart";
var productBuyUrl = ('#' + path + producPath);
var productId;
var token = '';


app.controller('ProductController',  function($scope, $http) {
	//url dos produtos
    $scope.productUrl = producPath;
    
	  $scope.addToCart = function(clickEvent) {
		  
		  var product = $scope.product;
		  
		  if(product != undefined){
			  
			  $http.post(urls.shoppingPath, product)
				 .then(function(response) {
			  	$('#cartCount').text(response.data);
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  });
			  
		  }
		  
	};
    
    
});

app.controller('UserController',  function($scope, $http) {
	
	var userId = 1;
	$scope.userUrl = '#';
	$scope.cartUrl = shoppingCartPath;
	
	$http({	
	    url: 'user/data', 
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
    		
    		//element.remove();
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
