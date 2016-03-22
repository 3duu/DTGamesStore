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
    //$scope.message = 'Bem vindo a DT Store';
    var path = window.location.pathname;
    var id = $("#productId").val();

    //url dos produtos
    //$scope.productUrl = (productBuyUrl + $scope.productId);

    
    if(id != null && id != undefined && id != 0 && id != ''){
    	
    	$http({	
    	    url: path.replace("/show", "/") + "pget/p?",
    	    method: "GET",
    	    params: {product: id}
    	 }).then(function(response) {
    		$scope.product = response.data;
         	//$scope.product.formatedValue = response.data.formatedValue;
         	$scope.product.productImage = ('data:image/jpg;base64,' + response.data.productImage);
        	
         }, function(response) {
         	alert('Erro ao obter produtos');
         });
    }
    
    
    //var path = window.location.pathname;
    var searchWord = $('#word').val();
    if(searchWord != null && searchWord != undefined && searchWord != 0 && searchWord != ''){
    	
    	path = path.replace('search', '').replace('/products', '');
    	$http.get(path + 'products/pget/s?product=' + searchWord).
        then(function(response) {
        	$scope.productsFinded = response.data;
        }, function(response){
        	alert('Erro ao obter dados');
        });
    }
      
	  $scope.addToCart = function(clickEvent) {
		  
		//var _token = angular.element('#csrf_token').val();
		  var _token =   $("meta[name='_csrf']").attr("content"); //angular.alement('_csrf').attr("content");
		  var _header =   $("meta[name='_csrf_header']").attr("content"); //angular.alement('_csrf_header').attr("content");
		  
		  var product = {productId: $scope.product.productId, priceValue: $scope.product.priceValue}; //$scope.product;
		  
		  var homeLink = angular.element('#urlBase').attr('href');
		  if(product != undefined){
			  
//			  $http.post(
//					  homeLink + '/' + urls.shoppingPath, 
//					  product)
			  $http({
				    url: homeLink + '/' + urls.shoppingPath, 
				    method: 'POST',
			  		data: product,
			  		//headers: {'Content-Type': _header, 'Cookie': _token}
				 })
				 .then(function(response) {
			  	//$('#cartCount').text();
			  	angular.element('#cartCount').text(response.data);
			  	$scope.cartCount = response.data;
			  }, function(response) {
			  	alert('Erro ao adicionar ao carrinho');
			  });
			  
		  }
	  }
	  
	

     
});
