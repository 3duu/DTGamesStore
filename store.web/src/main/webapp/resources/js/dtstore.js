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


app.controller('ProductController',  function($scope, $http) {
	//url dos produtos
    //$scope.productUrl = productPath;
    
	  $scope.addToCart = function(clickEvent) {
		  
		  var product = $scope.product;
		  
		  var homeLink = angular.element('#urlBase').attr('href');
		  if(product != undefined){
			  
			  $http.post(homeLink + '/' + urls.shoppingPath, product)
				 .then(function(response) {
			  	$('#cartCount').text(response.data);
			  	$scope.cartCount = response.data;
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  });
			  
		  }
		  
	};
    
});

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
