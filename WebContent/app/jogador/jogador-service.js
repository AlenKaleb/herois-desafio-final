moduleApp.factory("JogadorService", JogadorService);

JogadorService.$inject = ['$http'];

function JogadorService ($http) {
	const baseUrl = 'http://localhost:8080/curso-hackaton-cdi/jogador/';
	const urlNickname = baseUrl.concat('nickname/');
	const urlDifId = baseUrl.concat('listDifId/');
	
	let _getJogadores = function () {
		return $http.get(baseUrl);
	};
	
	let _listarJogadoresDifId = function (id) {
		return $http.get(urlDifId.concat(id));
	};

	let _inserir = function(jogador){
		console.log(jogador);
		return $http.post(baseUrl, jogador);
	}
	
	let _isExistNickname = function(nickname){
		return $http.get(urlNickname.concat(nickname));
	}
	
	
	return {
		getJogadores: _getJogadores,
		listarJogadoresDifId: _listarJogadoresDifId,
		inserir: _inserir,
		isExistNickname: _isExistNickname
	};	
}