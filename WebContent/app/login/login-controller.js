moduleApp.controller("LoginController", LoginController);

LoginController.$inject = ['$scope', '$location', 'LoginService', 'HeroiService'];

function LoginController($scope, $location, LoginService, HeroiService) {
    const self = this;
    self.service = LoginService;
    self.heroiService = HeroiService;
    let mensagem;
    
    self.usuario = {
		id: null,
        nickname: null,
        senha: null
    }

    self.login = function (usuario) {
    	usuario.senha = btoa(usuario.senha);
    	self.service.login(usuario)
            .then(function (response) {
            	console.log(response.data);
            	$location.path("/batalha");
            }, function (error) {
                console.log(error);
            });
    }
    
    self.getUserSession = function(){
    	return LoginService.getUserSession().then(function(response){
    		console.log(response.data);
    	},
    	function(error){
    		console.log(error.data);
    	});
    }
	
    self.irCadastrar = function(path){
    	$location.path(path);
    }
    
}