mainApp.factory('RegisterService', ['$resource', function($resource) {
	return  {
		createAccount: function(account) {
			console.log(account);
			return $resource('/RegiSTAR/rs/registar/addAccountToDatabase').save(account);  
		}	
	}
}]);