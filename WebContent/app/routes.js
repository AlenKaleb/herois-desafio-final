moduleApp.config(Config);

Config.$inject = ["$routeProvider"];

function Config($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "app/login/login.html"
        })
        .when("/cadastro-jogador", {
            templateUrl: "app/jogador/cadastro-jogador.html"
        })
        .when("/batalha", {
            templateUrl: "app/batalha/batalha.html"
        })
        .otherwise({
            redirectTo: "/"
        });
}