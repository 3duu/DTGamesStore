/**
 * 
 */
app.controller('ProductController', function($rootScope, $scope, $http, $routeParams, $route) {
    //$scope.message = 'Bem vindo a DT Store';
    var path = window.location.pathname;
    var id = $("#productId").val();
    //var img = $("#productImage").val();
    
//    if(img != null && img != '' && img != undefined){
    	//$scope.productImage = ('data:image/jpg;base64,' + img);
        //$("#productImage").val('');
//    }
    
    //url dos produtos
    //$scope.productUrl = (productBuyUrl + $scope.productId);

    
    if(id != null && id != undefined && id != 0 && id != ''){
    	
    	$http({	
    	    url: path.replace("/p?", "/") + "get/p?", 
    	    method: "GET",
    	    params: {product: id}
    	 }).then(function(response) {
         	$scope.name = response.data.name;
         	
         	$scope.productImage = ('data:image/jpg;base64,' + response.data.productImage);
        	
         }, function(response) {
         	alert('Fail');
         });
    }
    
    
});



