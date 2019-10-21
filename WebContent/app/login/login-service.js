moduleApp.service("LoginService", LoginService);

LoginService.$inject = ['$http'];

function LoginService($http) {
    const self = this;
    self.url = "http://localhost:8080/curso-hackaton-cdi/login/";
    self.auth = self.url.concat("auth");
    self.urlUser = self.url.concat("user");
    self.urlLogout = self.url.concat("logout");

    self.login = function (usuario) {
        return $http.post(self.auth, usuario);
    }
    
    self.getUserSession = function () {
        return $http.get(self.urlUser);
    }
    
    self.logout = function () {
        return $http.get(self.urlLogout);
    }
}