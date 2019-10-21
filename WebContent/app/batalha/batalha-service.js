moduleApp.factory("BatalhaService", BatalhaService);

BatalhaService.$inject = ['$http'];

function BatalhaService ($http) {
	const baseUrl = 'http://localhost:8080/curso-hackaton-cdi/batalha/';
	
	let _batalha = function(jogadorIdUm, jogadorIdDois){
		return $http.get(baseUrl.concat(jogadorIdUm).concat("/").concat(jogadorIdDois));
	}
	
	return {
		batalha : _batalha
	};
	
}