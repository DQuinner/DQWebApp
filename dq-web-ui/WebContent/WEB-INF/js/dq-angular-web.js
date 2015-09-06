angular.module("dq-angular-web", [])
	.controller("users", [ '$scope', '$http', function($scope, $http) {
		$http.get("http://localhost:8081/dq-web-ui/user-admin/all")
	    .success(function(response) {
	    	$scope.users = response;
	    });
		
	}])
	.controller("create_user", [ '$scope', '$http', function($scope, $http) {
		
		$scope.submit = function() {
			
			var userFormData = {
					"username":$scope.username,
					"password":$scope.password,
					"email":$scope.email,
					"forename":$scope.firstname,
					"surname":$scope.surname
				};
						
			var response = $http.post("http://localhost:8081/dq-web-ui/user-admin/new", userFormData);
			response.success(function(data, status, headers, config) {
				$scope.username=null;
				$scope.surname=null;
				$scope.password=null;
				$scope.firstname=null;
				$scope.email=null;
			
			});
			response.error(function(data, status, headers, config) {
				alert( "Exception details: " + JSON.stringify({data: data}));
			});
		};
	}]);