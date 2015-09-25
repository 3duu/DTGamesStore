/**
 * 
 */
app.controller('ShoppingController', function($scope, $http) {

	//Verificar carrinho de compras
    var userId = 1;
    
    $http({	
	    url: urls.cartInfo, 
	    method: "GET",
	    params: {userId: userId}
	 })
	 .then(function(response) {
    	//$scope.cartItems = response.data.count;
		 if(response.data != null)
		 $scope.cartProducts = response.data;
		 
    	$scope.$apply();
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});



