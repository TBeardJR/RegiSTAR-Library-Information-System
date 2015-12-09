mainApp.config(function($routeProvider) {
    $routeProvider
        .when('/main', {
            templateUrl: 'app/MainContent/mainContent.html'            
        })
        .when('/account', {
            templateUrl: 'app/Account/account.html'
        })   
        .when('/search', {
            templateUrl: 'app/Search/searchResults.html'
        })   
        .otherwise({redirectTo:"/main"})
});

