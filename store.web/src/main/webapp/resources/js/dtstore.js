/**
 * 
 */

var urls = 
{
		cartInfo: 'cartinfo',
		shoppingPath: 'shopping/additem'
};

var app = angular.module('dtstore', []);
var path = window.location.pathname;
var productId;
var token = '';


app.config(['$httpProvider', function ($httpProvider) {
	
	var _token =   $("meta[name='_csrf']").attr("content");
	var _header =   $("meta[name='_csrf_header']").attr("content");
	
	if(_token == undefined || _header == undefined)
		return;
	
    $httpProvider.defaults.headers.post[_header] = _token;
}]);

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
	
	//Get cart number
	$http({	
	    url: homeLink + '/shopping/cartcount', 
	    method: "GET"
	 })
	 .then(function(response) {
    	
    	if(response.data){
    		angular.element('#cartCount').text(response.data);
   		 	//$scope.cartCount = response.data;
    	}
    		
    }, function(response) {
    	alert('Erro ao recuperar informações do carrinho')
    });
    
	//$scope.$apply()
	
});


//core da loja
var dtCORE = {
		parameters : {},
		map        : {},
		url: {home: angular.element('#urlBase').attr('href')},
		
		//functions
		isEmpty: function(variable){
			if(variable != null && variable != undefined && variable != 0 && variable != ''){
				return false;
			}
			return true;
		},
		/*pagination: {itemsPerPage: 10, doPaging:function(data){
			
				var returnData = [{}];
				var count = 0;
				var page = 0;
				for(var i=0;i<data.length;i++){
					returnData[page].push(data[i]);
					if(count > 5){
						page++;
						count = 0;
					}		
				}
			
				return returnData;
		}}*/
};