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
	.controller("users", [ '$scope', '$http', function($scope, $http) {
		$http.get("http://localhost:8081/dq-rest-services/users/all")
	    .success(function(response) {
	    	$scope.users = response;
	    });
		
	}])
	.controller("create_user", [ '$scope', '$http', function($scope, $http) {
		
		$scope.submit = function() {
			
			var userFormData = {
					"username":$scope.username,
					"surname":$scope.surname,
					"password":$scope.password,
					"forename":$scope.firstname,
					"email":$scope.email
				};
				
			var response = $http.post("http://localhost:8081/dq-rest-services/users/new", userFormData);
			response.success(function(data, status, headers, config) {
				$scope.username=null;
				$scope.surname=null;
				$scope.password=null;
				$scope.firstname=null;
				$scope.email=null;
				$scope.new_user = data;
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
		};
}]);