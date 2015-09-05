angular.module("dq-angular-root", [])
    .controller("two_way_binding", ["$scope", function($scope) {
        $scope.favoriteWord;
        $scope.favoriteColor;
        $scope.favoriteShape;
    }])
	.controller("repeater", ["$scope", function($scope) {
		$scope.products = [
			{id: 1, name: "Hockey Puck"},
			{id: 2, name: "Golf club"},
			{id: 3, name: "Baseball Bat"},
			{id: 4, name: "Hurley"},
			{id: 5, name: "Football"},
			{id: 6, name: "Boxing Gloves"}
		];
	}])
	.controller("user", [ '$scope', '$http', function($scope, $http) {
		$scope.user = [{username: dq, email: dqTest}];
		/*$http({
			method : 'GET',
			url : 'http://localhost:8081/dq-rest-services/users/all'
		}).success(function(data, status, headers, config) {
			$scope.user = data;
		}).error(function(data, status, headers, config) {
			alert( "failure");
			alert("data = "+data);
			alert("status = "+status);
			alert("headers = "+headers);
			alert("config = "+config);
		});*/
	}]);