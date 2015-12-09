mainApp.factory('LoginService', ['$resource', function($resource) {
	return  {
		login: function(name,password) {			
			return $resource('/RegiSTAR/rs/registar/checkDatabaseForAccount/').get({name:name, password:password});  
		}	
	}
}])