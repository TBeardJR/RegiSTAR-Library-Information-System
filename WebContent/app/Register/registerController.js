mainApp.controller('RegisterController', ['$scope', function($scope) {
	$scope.showLoginPage = function() {
		$scope.readyToLogin = true;
		$scope.readyToRegister = false;
	}
	
	var account = {
		name: $scope.name,
		address: $scope.address,
		paymentInfo: $scope.paymentInfo,
		password: $scope.password,
		isAdministrator: isAdministrator(),
		isMemberShipActive: true
	}
	
	$scope.createAccount = function() {
		
	}
}])