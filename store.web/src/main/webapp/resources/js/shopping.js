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
				 	 cartData[cartIndex].productTotal = 'R$ ' + (response.data.products[i].priceValue * cartData[cartIndex].productCount).formatMoney(2, '.', ',');
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
			  	
			  	var productCount = 0;
			  	var totalValue = 0;
				 for(var i = 0; i < response.data.length; i++){
					 if(p.productId == response.data[i].productId){
						 productCount++;
						 totalValue += p.priceValue;
					 }
						 
				 }
			  	
			  	$('#cartCount').text(response.data.length);
			  	p.productCount = productCount;
			  	p.productTotal = totalValue;
			  	p.productTotal = 'R$ ' + p.productTotal.formatMoney(2, '.', ',');
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
				    url: homeLink + '/shopping/removeitem', 
				    method: 'POST',
			  		data: product
				 })
				 .then(function(response) {

			  	angular.element('#cartCount').text(response.data);
			  	$scope.cartCount = response.data;
			  	
			  	var productCount = 0;
			  	var totalValue = 0;
				 for(var i = 0; i < response.data.length; i++){
					 if(p.productId == response.data[i].productId){
						 productCount++;
						 totalValue += p.priceValue;
					 }	 
				 }
			  	
			  	angular.element('#cartCount').text(response.data.length);
			  	p.productCount = productCount;
			  	p.productTotal = totalValue;
			  	p.productTotal = 'R$ ' + p.productTotal.formatMoney(2, '.', ',');
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
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


