/**
 * 
 */
app.controller('HomeController', function($scope, $http) {
    var path = window.location.pathname;

    $http.get(path + 'products/mostsold').
    then(function(response) {
    	$scope.mostsoldlist = response.data;
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});



