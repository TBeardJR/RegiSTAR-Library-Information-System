mainApp.factory('SearchService', ['$resource', function($resource) {
	return  {
		searchForBook: function(title) {			
			return $resource('/RegiSTAR/rs/registar/checkDatabaseForBook/').get({title:title});  
		},	
		reserveBook: function(title) {			
			return $resource('/RegiSTAR/rs/registar/reserveBook/').get({title:title});  
		}	
	}
}])