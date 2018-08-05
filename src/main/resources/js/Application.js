var app = angular.module("myApp", ["ngRoute"]);
app.config(['$routeProvider',function($routeProvider) {
	console.log('routing....')
	  $routeProvider
	  .when("/test", {
		  controller: 'javaGeek',
	    templateUrl : "homepage.html"
	    	
	  });
app
		.controller(
				"javaGeek",
				function($scope, $http) {
					$scope.homepageData = [ {
						header : "header1",
						content : "this is conent"
					}, {
						header : "header2s",
						content : "this is conent2"
					} ]
					$scope.totalSize = 39;
					$scope.paginationList = [];
					$scope.startPage = function() {
						var req = {
							method : 'GET',
							url : 'http://localhost:8080/tutorialHomepageData',
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded',
								'Access-Control-Allow-Origin' : '*',
								'Access-Control-Allow-Methods' : 'GET',
								'Access-Control-Max-Age' : '3600',
								'Access-Control-Allow-Headers' : 'X-requested-with, Content-Type'
							}
						}
						$http(req).then(
								function(response) {
									//$scope.homepageData = response.data
								},
								function(response) {
									alert("didnt worked successfully"
											+ response.status)
									// called asynchronously if an error occurs
									// or server returns response with an error
									// status.
								});

					};
				});
app.controller("viewProduct", function($scope, $http) {
	$scope.productList = []
	$scope.categoryList = []
	$scope.getCategory=function(){
		$http.get('http://localhost:8080/categories').then(function(response){
			$scope.categoryList=response.data;
			alert('got the data')
		})
	};
	$scope.viewProducts = function() {
		var req = {
			method : 'GET',
			url : 'http://localhost:8080/bookdata'
		}
		$http(req).then(
				function(response) {
					$scope.productList = response.data
				},
				function(response) {
					alert("couldnt fetch product"
							+ response.status)
					// called asynchronously if an error occurs
					// or server returns response with an error
					// status.
				});
	}
	

});

app.filter('range', function() {
	return function(input, total) {
		// total = parseInt(total);
		for (var i = 1; i < total / 10 + 1; i++) {
			input.push(i);
		}
		return input;
	};
});

	}]);