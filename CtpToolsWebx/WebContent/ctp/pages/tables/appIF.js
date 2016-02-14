angular.module("myappIF", []);	
angular.module("myappIF").controller("ctpControllerIF", function ($scope, $http) {

	$scope.app = "Dados do Instrumento Financeiro";
	$scope.iifs = [];
	$scope.dataBase = "charitas";
		
	var url = "http://localhost:8080/WebServiceReynet/rest/instrumentofinanceiro/";
		
		$scope.obterIF = function() {
			
			  if (!angular.isDefined($scope.ctpCodIF) || $scope.ctpCodIF === '') {
				  var response = $http.get(url + "obtetListaIF/"+$scope.dataBase);
			      response.success(function(data) {
			      $scope.iifs = data;
			      
			      $scope.operacoes = [];
			      $scope.listaCartParticipante = [];
			      $scope.listaCartComitente = [];
			      $scope.listaAgenda = [];
			      
			      });
			  }else{
				  
				  var response = $http.get(url + "obtetIF/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaIF = data;
			      });
			      			      
			  }
		      
		};
			
	});
