/**
 * 
 */
app.controller('ShoppingController', function($scope, $http) {

	//Verificar carrinho de compras
    //var userId = 1;
    var homeLink = angular.element('#urlBase').attr('href');
    
    $http({	
	    url: homeLink + '/shopping/' + urls.cartInfo, 
	    method: "GET"
	    //params: {userId: userId}
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
			 
			 if(cartData.length != 0)
				 $scope.cartProducts = cartData;
		
		 }
		 
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
    
    $scope.newCartItem = function(p) {
		  
    	var homeLink = angular.element('#urlBase').attr('href');
		  if(p != undefined){
			  
			  var product = {productId: p.productId, priceValue: p.priceValue};
			  
			  $http({
				    url: homeLink + '/' + urls.shoppingPath, 
				    method: 'POST',
			  		data: product
				 })
				 .then(function(response) {
			  	//$('#cartCount').text();
			  	angular.element('#cartCount').text(response.data);
			  	$scope.cartCount = response.data;
			  	
			  	$('#cartCount').text(response.data);
			  	p.productCount++;
			  	p.productTotal += p.priceValue;
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  });
			  
		  }
		  
	};
	
	
	
	$scope.removeCartItem = function(p) {
		  
		var homeLink = angular.element('#urlBase').attr('href');
		  if(p != undefined){
			  
			  var product = {productId: p.productId, priceValue: p.priceValue};
			  
			  $http({
				    url: homeLink + '/' + urls.shoppingPath, 
				    method: 'POST',
			  		data: product
				 })
				 .then(function(response) {
			  	//$('#cartCount').text();
			  	angular.element('#cartCount').text(response.data);
			  	$scope.cartCount = response.data;
			  	
			  	$('#cartCount').text(response.data);
			  	p.productCount++;
			  	p.productTotal += p.priceValue;
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  });
			  
		  }
		
		
		
		  var product = $scope.product;
		  
		  if(product != undefined){
			  
			  $http.post("removeitem", product)
				 .then(function(response) {
			  	$('#cartCount').text(response.data);
			  	$scope.product.productCount--;
			  	$scope.shoppingCart.count--;
			  	$scope.product.productTotal -= $scope.product.priceValue;
			  }, function(response) {
			  	alert('Erro ao remove item do carrinho');
			  });
			  
		  }
		  
	};
    
});

function arrayContais(array, object){
	for( var i = 0; i < array.length; i++ )
		if(array[i]== object)
			return true;
		
	return false;
}


