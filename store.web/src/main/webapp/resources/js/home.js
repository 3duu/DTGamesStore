/**
 * 
 */
var app = angular.module('Home', []);
app.controller('HomeController',  function($scope, $http, $timeout) {
    $scope.message = 'Bem vindo a DT Store';
    

    function getUsersFromLocal($scope,$http) {
        $http.get('/products/mostsold').
          success(function(data) {
        	  alert(data);
          });
      }

      getUsersFromLocal($scope, $http); // pass this services manually
    
  //Carregar produtos mais vendidos
//    $http.get('/products/mostsold').success(function(data) {
//		//$scope.greeting = data;
//    	alert(data);
//	})
    
    
//    $http.get('/products/mostsold').  
//    then(function(response) {
//      alert(response);
//    }, function(response) {
//    	alert('Fail');
//    });
    
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

var path = window.location.pathname;

