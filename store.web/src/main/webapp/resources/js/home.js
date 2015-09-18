/**
 * 
 */
var app = angular.module('Home', []);
app.controller('HomeController', function($scope, $http, $timeout) {
    $scope.message = 'Bem vindo a DT Store';
    var path = window.location.pathname;
  //Carregar produtos mais vendidos
//    $http.get('/products/mostsold').success(function(data) {
//		//$scope.greeting = data;
//    	alert(data);
//	})
    
    var data = undefined;
    $http.get(path + '/products/mostsold').
    then(function(response) {
    	$scope.mostsoldlist = response.data;
    	//data = response;
    	
    }, function(response) {
    	alert('Fail');
    });
    
//    $http.get('http://rest-service.guides.spring.io/greeting').
//    success(function(data) {
//        $scope.greeting = data;
//    });
    
//    $http({
//        method: 'GET',
//        url: '/products/mostsold',
//        headers: {
//            "Content-Type": "application/json",
//            "Accept": "text/plain"
//        }
//    })
//    .then(function (response) {
//        if (response.status == 200) {
//        	alert(response);
//        }
//        else {
//        	alert('Fail');
//        }
//    });
    
});



