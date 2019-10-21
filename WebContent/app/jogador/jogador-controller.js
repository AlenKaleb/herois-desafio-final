moduleApp.controller("JogadorController", JogadorController);

JogadorController.$inject = ["$scope", "$location","JogadorService"];

function JogadorController ($scope, $location, JogadorService) {
	const vm = this;
	vm.app = "Jogador";
	vm.service = JogadorService;
	vm.jogadores = [];
	vm.mensagem = "";

	vm.jogador = {
			id: null,
			nickname: null,
			senha: null,
			personagem: null
	}
	
	vm.init = function(){
		vm.login = true;
	}

	vm.carregarJogadores = function () {
		vm.service.getJogadores().success(function (data) {
			vm.jogadores = data;
		}).error(function (data, status) {
			vm.message = "Aconteceu um problema: ".concat(data);
		});
	}
	
	vm.isExistNickname = function(nickname){
		vm.service.isExistNickname(nickname).then(function(response){
			vm.mensagem = response.data.mensagem;
			console.log(response.data);
		},
		function(error){
			vm.mensagem = error.data.mensagem;
			console.log(error.data.mensagem);
		});
	}

	vm.cadastrar = function(jogador){
		jogador.senha = btoa(jogador.senha);
		vm.service.inserir(jogador).then(function (response) {
			vm.message = "Jogador cadastrado com sucesso ".concat(jogador.nickname);
			jogador.senha = null;
			$location.path("/batalha");
		},
		function (error) {
			vm.message = "Aconteceu um problema: ".concat(error);
			jogador.senha = null;
		});
		console.log("Enviado");
	}
	
	vm.irLogin = function (path) {
		$location.path(path);
	}
	
}