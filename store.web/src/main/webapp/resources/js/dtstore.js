/**
 * 
 */
var app = angular.module('dtstore', []);
var path = window.location.pathname;
var producPath = "products/p?code=";
var productBuyUrl = ('#' + path + producPath);
var productId;

app.controller('ProductController',  function($scope, $http) {
	//url dos produtos
    $scope.productUrl = producPath;
    
    //Verificar carrinho de compras
    var userId = 0;
    
    $http({	
	    url: 'shopping/cart', 
	    method: "GET",
	    params: {userId: userId}
	 })
	 .then(function(response) {
    	$scope.cartItems = response.data.count;
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});

app.controller('UserController',  function($scope, $http) {
	
	var element = angular.element('<div id="loading" class="loading">' + '<img src="../styling/img/loading.gif" alt="loading .... ">' + '</div>');

	$scope.userUrl = '#';
    $http.get(path + 'user/cartcount').
    then(function(response) {
    	
    	if(response.data.name != ''){
    		$('#loginLink').remove();
    		$scope.account = 'Minha conta';
    	}
    		
    	else{
    		$scope.account = 'Fazer Login';
    		$('#userDropdown').remove();
    		
    		element.remove();
    	}
    		
    	$scope.account = response.data;
    }, function(response) {
    	alert('Impossível validar sessão');
    	$scope.account = 'Fazer Login';
    	$('#userDropdown').remove();
    	element.remove();
    });
    
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
