/**
 * 
 */
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
         	$scope.name = response.data.name;
         	$scope.priceValue = response.data.formatedValue;
         	$scope.console = response.data.console;
         	
         	$scope.description = response.data.description;
         	$scope.productImage = ('data:image/jpg;base64,' + response.data.productImage);
        	
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
    
     
});
