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
    	
		 if(response.data != null){
			 var cartData = [{}];
			 var cartIndex = 0;
			 for(var i = 0; i < response.data.products.length; i++){
				 var contais = false;
				 for(var j = 0; j < cartData.length; j++)
					 if(response.data.products[i].productId == cartData[j].productId)
						 contais = true;
					
				 if(!contais){
					 cartData[cartIndex] = response.data.products[i];
				 	 cartData[cartIndex].productCount = response.data.productCount[response.data.products[i].productId];
				 	 cartData[cartIndex].productTotal = response.data.products[i].priceValue * cartData[cartIndex].productCount;
				 	 cartIndex++;
				 }	 
			 }
			 
			 $scope.cartProducts = cartData;
		 }
		 
    	//$scope.$apply();
    	
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});

function arrayContais(array, object){
	for( var i = 0; i < array.length; i++ )
		if(array[i]== object)
			return true;
		
	return false;
}


