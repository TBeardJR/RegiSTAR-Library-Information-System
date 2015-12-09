mainApp.controller('LoginController', ['$scope', function($scope) {
	$scope.loginLayout = "login-box";
	$scope.showRegistrationPage = function() {
		$scope.readyToRegister = true;
		$scope.readyToLogin = false;
		$scope.loginLayout = "register-box";
	}
}]);