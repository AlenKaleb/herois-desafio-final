moduleApp.controller("HeroiController", HeroiController);

HeroiController.$inject = ["$scope", "HeroiService"];

function HeroiController ($scope, HeroiService) {
	const vm = this;
	vm.app = "Heróis";
	vm.service = HeroiService;
	vm.herois = [];

	vm.init = function(){
		vm.carregarHerois();
	}

	vm.carregarHerois = function () {
		vm.service.getHerois().then(function (response) {
			vm.herois = response.data;
		},
		function (error) {
			vm.message = "Aconteceu um problema: " + error;
		});
	};

}