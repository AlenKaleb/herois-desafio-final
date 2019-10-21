moduleApp.controller("BatalhaController", BatalhaController);

BatalhaController.$inject = ["$scope", "$location","BatalhaService","JogadorService", "HeroiService", "LoginService"];

function BatalhaController ($scope, $location, BatalhaService ,JogadorService, HeroiService, LoginService) {
	const vm = this;
	vm.app = "";
	vm.jogadorService = JogadorService;
	vm.batalhaService = BatalhaService;
	vm.loginService = LoginService;
	vm.jogadores = [];
	vm.herois = [];
	vm.message = "";
	
	vm.jogadorPrimario = {
		id: null,
		personagem : null
	}
	
	vm.jogadorSecundario = {
		id: null,
		personagem : null
	}
	
	vm.init = function(){
		vm.carregarJogadores();
		vm.userName();
	}

	vm.carregarJogadores = function () {
		vm.loginService.getUserSession().then(function(response){
			vm.jogadorService.isExistNickname(response.data.nickname).then(function(response){
				vm.jogadorService.listarJogadoresDifId(response.data.id).then(function (response) {
					vm.jogadores = response.data;
				},
				function (error) {
					console.log("Error: ".concat(error));
				});
			});
		});
	}
	
	vm.userName = function () {
		vm.loginService.getUserSession().then(function(response){
			vm.message = response.data.nickname;
		},
		function (error) {
			vm.message = "Aconteceu um problema: ".concat(error);
		});
	}
	
	vm.batalhar = function(jogadorIdUm, jogadorIdDois){
		vm.batalhaService.batalha(jogadorIdUm, jogadorIdDois).then(function(response){
			console.log(response.data);
		},
		function(error){
			console.log(error);
		});
	}
	
}