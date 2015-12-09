mainApp.controller('MainController', ['$scope', 'RegisterService', 'LoginService', 'AccountService', 'SearchService',
  function($scope, RegisterService, LoginService, AccountService, SearchService) {	
	$scope.list = {
			listOfBooksReserved: []
	};
	
	$scope.data = {
			newName: "",
			newAddress: "",
			newPaymentInfo: "",
			newPassword: "",
			moneyToAdd: 0.0
			
	};
	$scope.readyToLogin = true;
	$scope.readyToRegister = false;
	$scope.loginLayout = "login-box";	
	if($scope.readyToLogin) {
		$scope.layout = "login-page";		
	} else if($scope.readytoRegister) {
		$scope.layout = "register-page";
	} else {
		$scope.layout = "skin-blue layout-top-nav";
	}
	
	$scope.showRegistrationPage = function() {
		$scope.readyToRegister = true;
		$scope.readyToLogin = false;
		$scope.loginLayout = "register-box";
	}
	$scope.showLoginPage = function() {
		$scope.readyToLogin = true;
		$scope.readyToRegister = false;
	}
	
	
	
	function isAdministrator() {
		if($scope.administratorKey == 123) {
			return true;
		} else {
			return false;
		}
	}
	
	$scope.createAccount = function() {
		var account = {
				isMembershipActive: true,
				isAdministrator: isAdministrator(),
				name: $scope.name,
				address: $scope.address,
				paymentInfo: $scope.paymentInfo,
				password: $scope.password				
			}
		var accountJSON = JSON.stringify(account);
		console.log(account);
		RegisterService.createAccount(accountJSON);
		$scope.readyToLogin = true;
		$scope.readyToRegister = false;
	}
	
	$scope.signIn = function() {		
		$scope.loginInformation = LoginService.login($scope.loginName, $scope.loginPassword).$promise
			.then(function(response) {				
				console.log(response);				
				if(response.doesAccountExist == "true") {
					$scope.readyToLogin = false;
					$scope.readyToRegister = false;	
					$scope.layout = "skin-blue layout-top-nav"
					$scope.loginResponse = response;
					$scope.oldName = response.account.name;
					$scope.loginFinished = true;
					if(response.account.isAdministrator == true) {
						$scope.accountType = "Administrator";
					} else {
						$scope.accountType = "Member";
					}	
					if(response.account.isMembershipActive == true) {
						$scope.isMembershipActive = "Yes";
					} else {
						$scope.isMembershipActive = "No";
					}
				} else {
					console.log("Login failed");
				}
			});			
	}
	$scope.signOut = function() {
		$scope.readyToLogin = true;
		$scope.loginLayout = "login-box";
		$scope.layout = "login-page";
		$scope.loginName = "";
		$scope.loginPassword = "";
		console.log($scope.readyToLogin);
		console.log("You signed out");
	}
	
	$scope.showChangeAccountInfoForm = function() {
		$scope.changeAccountInfo = true;
	}
	
	$scope.hideChangeAccountInfoForm = function() {
		$scope.changeAccountInfo = false;
	}
	
	var isCurrentlyAdministrator = function() {
		if($scope.accountType == "Administrator") {
			return true;
		} else {
			return false;
		}
	}
	
	$scope.changeAccountInformation = function() {
		var account = {	
				isMembershipActive: true,
				isAdministrator: isCurrentlyAdministrator(),
				name: $scope.data.newName,
				address: $scope.data.newAddress,
				paymentInfo: $scope.data.newPaymentInfo,
				password: $scope.data.newPassword,	
				balance: $scope.data.moneyToAdd
			}
		
		if($scope.data.newName) {
			$scope.loginResponse.account.name = $scope.data.newName;
		}
		if($scope.data.newAddress){
			$scope.loginResponse.account.address = $scope.data.newAddress;
		}
		if($scope.data.newPaymentInfo) {
			$scope.loginResponse.account.paymentInfo = $scope.data.newPaymentInfo;
		}
		if($scope.data.newPassword) {
			$scope.loginResponse.account.password = $scope.data.newPassword;
		}
		console.log($scope.data.moneyToAdd);
		console.log($scope.data.newName);
		console.log($scope.data.newAddress);
		if(!$scope.data.moneyToAdd) {
			console.log($scope.data.moneyToAdd);
			$scope.data.moneyToAdd = 0.0;
		}
		AccountService.changeAccountInfo($scope.loginResponse.account.name, $scope.loginResponse.account.address, 
				$scope.loginResponse.account.paymentInfo, $scope.loginResponse.account.password, 
				true, isCurrentlyAdministrator(), $scope.oldName, $scope.data.moneyToAdd, $scope.loginResponse.account.balance);	
		
		if($scope.data.moneyToAdd > 0) {
			$scope.loginResponse.account.balance = parseInt($scope.data.moneyToAdd) + $scope.loginResponse.account.balance;
		}
	}
	
	$scope.deleteAccount = function() {
		AccountService.deleteAccount($scope.loginResponse.account.name, $scope.loginResponse.account.password);
		$scope.signOut();
	}
	
	$scope.search = function() {
		console.log($scope.searchQuery);
		SearchService.searchForBook($scope.searchQuery).$promise
			.then(function(response) {
				$scope.book = response;
			})
	}
	
	$scope.makePayment = function() {
		var price = -$scope.book.price;
		AccountService.changeAccountInfo($scope.loginResponse.account.name, $scope.loginResponse.account.address, 
				$scope.loginResponse.account.paymentInfo, $scope.loginResponse.account.password, 
				true, isCurrentlyAdministrator(), $scope.loginResponse.account.name, price, $scope.loginResponse.account.balance);
		$scope.loginResponse.account.balance = parseInt(price) + $scope.loginResponse.account.balance;
	}
	
	$scope.reserveBook = function() {		
		SearchService.reserveBook($scope.book.title).$promise
		.then(function(response) {
			$scope.reservedBook = response;
			console.log(response);
			console.log($scope.reservedBook);
		});
		alert($scope.book.title + " has been reserved!");
		
		$scope.list.listOfBooksReserved.push($scope.book.title);
		console.log($scope.list.listOfBooksReserved);
	}
}])












