(function() {
  var app, dependencies;

  dependencies = ['ngRoute', 'ngResource', 'ui.bootstrap', 'myApp.chat'];

  app = angular.module('myApp', dependencies);

  this.chatModule = angular.module('myApp.chat', []);

}).call(this);
