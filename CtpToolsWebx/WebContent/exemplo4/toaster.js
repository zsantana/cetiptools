var app = angular.module("demo", ['toaster'])

app.controller("demoController", function($scope, $http, toaster) {

  //Initial Holding Object for our Notifications - set as empty
  $scope.notifications = {};

  //Load Notifications for this current user from the View using the Domino REST API
  //For the demo we will use a local sample.json file which mimics the Domino JSON Data
  $scope.loadNotifications = function() {
    $http({
      method:'get',
      url: 'https://s3-us-west-2.amazonaws.com/s.cdpn.io/60204/sample_3.json'
      //url: '/notification.nsf/api/data/collections/name/(LUNotificationsAwaiting)?category=<Computed Value>'
    }).success(function(data, status, headers, config) {
       $scope.notifications = data;
    })
  }


  //This code watches the notifications object - if it changes then it calls another function
  //This helps to decouple your loading data logic.
  $scope.$watch('notifications', function(newVal, oldVal) {
    if (oldVal == newVal) return;
    //We have notifications - loop through them and show them
    $scope.displayNotifications();

  });

  $scope.$on('toaster-Removed', function(event, toasterObj) {
    $scope.handleNotificationClick(toasterObj.toaster)
  });

  $scope.displayNotifications = function() {
    angular.forEach($scope.notifications, function(value, key) {
      console.log(value['@unid'])
      if (value.sticky == "No") {
        sticky = 3000
      } else {
        sticky = 0
      }
      toaster.pop(value.type, value.title, value.message, sticky, 'trustedHtml', "", value['@unid']);
    });
  }

  //For the demo we will hold a list of clicked toasts so we can display the result
  $scope.demoClickedToasts = []

  $scope.handleNotificationClick = function(toasterObj) {
    //Normally here we would issue a PATCH request to Domino to update the notifcation document
    //For the demo we will just output some content
console.log(toasterObj);
    $scope.demoClickedToasts.push(toasterObj);

    /**
    $http({
        method: "PATCH",
        url: '/notification.nsf/api/data/documents/unid/'+ toasterObj.unid,
        data:{'Status':'Seen'}
    })
    **/

  }

})