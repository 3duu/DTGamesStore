/**
 * 
 */
app.controller('HomeController', function($scope, $http) {

    var homeLink = angular.element('#urlBase').attr('href');
    $http.get(homeLink + '/products/mostsold').
    then(function(response) {
    	
    	/*
    	$scope.filteredTodos = []
		  ,$scope.currentPage = 1
		  ,$scope.numPerPage = 10
		  ,$scope.maxSize = 5;

		  $scope.makeTodos = function() {
		    $scope.todos = [];
		    for (i=1;i<=1000;i++) {
		      $scope.todos.push({ text:"todo "+i, done:false});
		    }
		  };
		  $scope.makeTodos(); 

		  $scope.numPages = function () {
		    return Math.ceil($scope.todos.length / $scope.numPerPage);
		  };

		  $scope.$watch("currentPage + numPerPage", function() {
		    var begin = (($scope.currentPage - 1) * $scope.numPerPage)
		    , end = begin + $scope.numPerPage;

		    $scope.filteredTodos = $scope.todos.slice(begin, end);
		  });*/
    	
    	////////////////////////////////////////
    	$scope.mostsoldlist = response.data;
    	
    	//dtCORE.pagination.doPaging(response.data);
    	
    }, function(response) {
    	alert('Erro ao obter dados');
    });
    
});



