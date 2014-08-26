dependencies = [
    'ngRoute',
    'ngResource',
    'ui.bootstrap',
    'myApp.chat'
]

app = angular.module('myApp', dependencies)

@chatModule = angular.module('myApp.chat', [])