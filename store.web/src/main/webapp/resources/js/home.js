/**
 * 
 */

//var app = angular.module("Home", []);
//
//app.controller("HomeController", function ($scope) {$scope.message("Hello world")});


var app = angular.module('Home', []);
app.controller('HomeController',  ['$scope', function($scope) {
    $scope.message = "Fuck Yeah!";
}]);

var path = window.location.pathname;
//var page = path.split("/").pop();
//console.log( page );
//alert(location.pathname);