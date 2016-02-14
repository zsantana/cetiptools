angular.module("ctpApp", []);	
angular.module("ctpApp").controller("ctpController", function ($scope, $http, $interval) {

    $interval( function(){ $scope.obterOperacoes(); }, 5000);
	
	$scope.dataBase = "charitas";
		
	var url = "http://localhost:8080/CtpToolsWebx/rest/";

	var serviceIF 		= "instrumentofinanceiro";
	var serviceOperacao = "operacao";
	var serviceCustodia = "custodia";
	var serviceEvento 	= "evento";
	var serviceResumoOperacao = "resumoOperacao";

	$scope.set_color_operacao = function(operacao){
		
		if (operacao.codStatusOpeacao == 'FINALIZADA'){
			return { color : "green" }
		}else if (operacao.codStatusOpeacao == 'PEND. LIQ. FINANCEIRA'){
			return { color : "yellow"}
		}else {
			return {color : "red"}
		}
		
	};	
	
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
	
	$scope.obterIFporTipoIF = function(){
		
		if ( $scope.mdTipoIF === "") {	
			 var response = $http.get(url + serviceIF + "/obterListaIF/"+ $scope.dataBase);
		      response.success(function(data) {
		      $scope.listaIFTipoIFs = data;
		      });
			
		} else{
			
			var response = $http.get(url + serviceIF + "/obterIFporTipoIF/" + $scope.mdTipoIF + "/" +$scope.dataBase);
		      response.success(function(data) {
		      $scope.listaIFTipoIFs = data;
		      });
		} 
	}
		
		
	$scope.obterOperacoes = function () {
		
		if (!angular.isDefined($scope.autorefresh) || $scope.autorefresh ){
			
			$scope.autorefresh=true;

			var response = $http.get(url + serviceOperacao + "/obterOperacao/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      response.success(function(data) {
			      $scope.listaOperacao = data;
			      });
		}
	}
	
	
	   $scope.obterComitente = function(){
			
			if (!angular.isDefined($scope.codDocumento) || $scope.codDocumento === '') {	
				  var restCustodia = $http.get(url + serviceCustodia + "/obterCarteiraComitente/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
				  restCustodia.success(function(data) {
			      $scope.listaCartComitente = data;
			      });
				
			} else{
				
				 var restCustodia = $http.get(url + serviceCustodia + "/obterComitente/" + $scope.codDocumento + "/" + $scope.ctpCodIF + "/" +$scope.dataBase);
				  restCustodia.success(function(data) {
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
				  
				  var restIF = $http.get(url + serviceIF + "/obtetIF/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
				  restIF.success(function(data) {
			      $scope.listaIF = data;
			      });
			      
			      var restOperacao = $http.get(url + serviceOperacao + "/obterOperacao/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      restOperacao.success(function(data) {
			      $scope.listaOperacao = data;
			      });
			      
			      var restCustPartic = $http.get(url + serviceCustodia + "/obterCarteiraParticipante/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      restCustPartic.success(function(data) {
			      $scope.listaCartParticipante = data;
			      });
			      
			      var restCustComit = $http.get(url + serviceCustodia + "/obterCarteiraComitente/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      restCustComit.success(function(data) {
			      $scope.listaCartComitente = data;
			      });
			      
			      
			     // EVENTO: ==============================================================================
			      var restEvento = $http.get(url + serviceEvento + "/obterAgendaEvento/"+ $scope.ctpCodIF + "/" +$scope.dataBase);
			      restEvento.success(function(data) {
			      $scope.listaEvento = data;
			      });
			     // ======================================================================================== 
			      
			      
			      // MENSAGEM: ==============================================================================
			      var restMensagem = $http.get(url + serviceResumoOperacao + "/obterTotMensagem/"+ $scope.dataBase);
			      restMensagem.success(function(data) {
			      $scope.totMensagem = data;
			      });
			      // ========================================================================================
			      
			      
			     // TELA: ===================================================================================
			      var restTela = $http.get(url + serviceResumoOperacao + "/obterTotTela/"+ $scope.dataBase);
			      restTela.success(function(data) {
			      $scope.totTela = data;
			      });
			      // ========================================================================================
			      
			     
			      // ARQUIVO: ===============================================================================
			      var restArquivo = $http.get(url + serviceResumoOperacao + "/obterTotArquivo/"+ $scope.dataBase);
			      restArquivo.success(function(data) {
			      $scope.totArquivo = data;
			      });
			      // ========================================================================================
			      
			      
			      // DEAD LETTER: ===========================================================================
			      var restDeadLetter = $http.get(url + serviceResumoOperacao + "/obterTotDeadLetter/"+ $scope.dataBase);
			      restDeadLetter.success(function(data) {
			      $scope.totDeadLetter = data;
			      });
			      // ========================================================================================
			      
			      
			      
			      // VALOR FINANCEIRO MULT-LATERAL: =========================================================
			      var restValMultLateral = $http.get(url + serviceResumoOperacao + "/obterTotFinMultLateral/"+ $scope.dataBase);
			      restValMultLateral.success(function(data) {
			      $scope.totFinMultLateral = data;
			      });
			      // ========================================================================================
			      
			      
			     // VALOR FINANCEIRO BRUTA STR: =============================================================
			      var restValBrutaStr = $http.get(url + serviceResumoOperacao + "/obterTotFinBrutaStr/"+ $scope.dataBase);
			      restValBrutaStr.success(function(data) {
			      $scope.totFinBrutaStr = data;
			      });
			      // ========================================================================================
			      
			      
			  }
		      
		};

	});
