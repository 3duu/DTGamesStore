/**
 * 
 */

app.config(['$httpProvider', function ($httpProvider) {
	
	var _token =   $("meta[name='_csrf']").attr("content");
	var _header =   $("meta[name='_csrf_header']").attr("content");
	
	if(_token == undefined || _header == undefined)
		return;
	
    $httpProvider.defaults.headers.post[_header] = _token;
}]);

app.controller('ProductController', function($rootScope, $scope, $http, $routeParams, $route) {

	//Get most sold products
    var path = angular.element('#urlBase').attr('href');
    var id = angular.element("#productId").val();

    if(!dtCORE.isEmpty(id)){
    	
    	$http({	
    	    url: path + '/products/pget/p',
    	    method: 'GET',
    	    params: {product: id}
    	 }).then(function(response) {
    		 
    		$scope.product = response.data;
         	$scope.product.productImage = ('data:image/jpg;base64,' + response.data.productImage);
        	
         }, function(response) {
         	alert('Erro ao obter produtos');
         });
    }
    
    
    //var path = window.location.pathname;
    var searchWord = angular.element('#word').val();
    if(!dtCORE.isEmpty(searchWord)){
    	
    	$http({
    	    url: path + '/products/pget/s',
    	    method: 'GET',
    	    params: {product: searchWord}
    	 }).then(function(response) {
        	$scope.productsFinded = response.data;
        }, function(response){
        	alert('Erro ao obter dados');
        });
    }
      
	  $scope.addToCart = function(p) {
		  
		  var homeLink = angular.element('#urlBase').attr('href');
		  if(p != undefined){
			  
			  var product = {productId: p.productId, priceValue: p.priceValue};
			  
			  $http({
				    url: homeLink + '/' + urls.shoppingPath, 
				    method: 'POST',
			  		data: product
				 })
				 .then(function(response) {
			  	
					 var productCount = 0;
					 for(var i = 0; i < response.data.length; i++){
						 if(p.productId == response.data[i].productId)
							 productCount++;
					 }
					 
			  	angular.element('#cartCount').text(response.data.length);
			  	$scope.cartCount = response.data.length;
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  }); 
		  }
	  }
	  
	  
     
});
