moduleApp.factory("HeroiService", HeroiService);

HeroiService.$inject = ["$http"];
		
function HeroiService ($http) {
	const baseUrl = 'http://localhost:8080/curso-hackaton-cdi/heroi';
	var _getHerois = function () {
		return $http.get(baseUrl);
	};

	return {
		getHerois: _getHerois
	};	
}