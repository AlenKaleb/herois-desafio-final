const moduleApp = angular.module("heroi", ["ngRoute"]);

moduleApp.run(Run);

Run.$inject = ['$rootScope', '$location', 'LoginService'];

function Run($rootScope, $location, LoginService) {
	
	$rootScope.$on('$routeChangeStart', function (evt, route) {
    if (route.originalPath !== "/batalha") {
        LoginService.getUserSession().then(function(response){
    		if (response.data != "") {
                $location.path("/batalha");
            }
    	},
    	function(error){
    		console.log(error);
    	})
        
    } else {
        if (LoginService.usuario) {
            $location.path("/batalha");
        }
    }
});
}