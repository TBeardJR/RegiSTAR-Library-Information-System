mainApp.factory('AccountService', ['$resource', function($resource) {
	return  {
		changeAccountInfo: function(newName, newAddress, newPaymentInfo, newPassword, isMembershipActive, isAdministrator, 
				oldName, moneyToAdd, oldBalance) {			
			return $resource('/RegiSTAR/rs/registar/updateAccountInfo/', 
					{newName: newName, newAddress: newAddress, newPaymentInfo: newPaymentInfo, 
				newPassword: newPassword, isMembershipActive: isMembershipActive, 
				isAdministrator: isAdministrator, oldName: oldName, moneyToAdd: moneyToAdd, oldBalance: oldBalance}).save();  
		},	
		
		deleteAccount: function(name, password) {			
			return $resource('/RegiSTAR/rs/registar/deleteAccount/', 
					{name: name, password: password}).save();  
	}	
		
	}
}])