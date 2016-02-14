angular.module("ctpAppMensagem", []);	
angular.module("ctpAppMensagem").controller("ctpCtlMensagem", function ($scope, $http) {

	$scope.dataBase = "charitas";
		
	var url = "http://localhost:8080/CtpToolsWebx/rest/";

	var serviceIF 		= "instrumentofinanceiro";
	var serviceOperacao = "operacao";
	var serviceCustodia = "custodia";
	var serviceEvento 	= "evento";
		
	
	$scope.obterModalidade = function(){
			
			if ( $scope.mdModalidade === "") {	
				 var response = $http.get(url + serviceOperacao + "/obterOperacao/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaOperacao = data;
			      });
				
			} else{
				
				var response = $http.get(url + serviceOperacao + "/obterModalidadeOperacao/" + $scope.mdModalidade + "/" + $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaOperacao = data;
			      });
			} 
		}
		
		
	$scope.obterComitente = function(){
			
			if (!angular.isDefined($scope.codDocumento) || $scope.codDocumento === '') {	
				 var response = $http.get(url + serviceCustodia + "/obterCarteiraComitente/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaCartComitente = data;
			      });
				
			} else{
				
				var response = $http.get(url + serviceCustodia + "/obterComitente/" + $scope.codDocumento + "/" + $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaCartComitente = data;
			      });
			} 
		}
		
			
		$scope.obterIF = function() {
			
			  if (!angular.isDefined($scope.ctpCodIF) || $scope.ctpCodIF === '') {
				  var response = $http.get(url + serviceIF + "/obtetListaIF/"+$scope.dataBase);
			      response.success(function(data) {
			      $scope.iifs = data;
			      
			      $scope.operacoes = [];
			      $scope.listaCartParticipante = [];
			      $scope.listaCartComitente = [];
			      $scope.listaAgenda = [];
			      
			      });
			  }else{
				  
				  var response = $http.get(url + serviceIF + "/obtetIF/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaIF = data;
			      });
			      
			      var response = $http.get(url + serviceOperacao + "/obterOperacao/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaOperacao = data;
			      });
			      
			      var response = $http.get(url + serviceCustodia + "/obterCarteiraParticipante/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaCartParticipante = data;
			      });
			      
			      var response = $http.get(url + serviceCustodia + "/obterCarteiraComitente/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaCartComitente = data;
			      });
			      
			      var response = $http.get(url + serviceEvento + "/obterAgendaEvento/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaEvento = data;
			      });
			      
			  }
		      
		};

	});
