/**
 * 
 */
app.controller('HomeController', function($scope, $http) {

    var homeLink = angular.element('#urlBase').attr('href');

    $http.get(homeLink + '/products/mostsold').
    then(function(response) {
    	$scope.mostsoldlist = response.data;
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});



