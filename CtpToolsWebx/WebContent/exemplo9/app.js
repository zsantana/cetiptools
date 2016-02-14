angular.module('plunker', ['angularCharts']);

function MainCtrl($scope) {
  $scope.config = {
    title: 'Operações',
    tooltips: true,
    labels: true,
    mouseover: function() {},
    mouseout: function() {},
    click: function() {},
    legend: {
      display: true,
      //could be 'left, right'
      position: 'right'
    }
  };

  $scope.data = {
    series: ['BRADESCO', 'SANTANDER', 'ITAU', 'SAFRA', 'CAIXA'],
    data: [{
      x: "DEB",
      y: [100, 500, 300,234],
      tooltip: "this is tooltip"
    }, {
      x: "CCB",
      y: [300, 100]
    }, {
      x: "COE",
      y: [351, 50]
    }, {
      x: "SWAP",
      y: [54, 60]
    }]
  };
}