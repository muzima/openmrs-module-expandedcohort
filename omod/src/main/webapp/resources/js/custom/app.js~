var cumulativecohort = angular.module('cumulativecohort', ['ui.bootstrap', 'filters']);

cumulativecohort.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);
        $routeProvider.when('/cohortdefinitions', {controller: CohortDefinitionsCtrl,
            templateUrl: '../../moduleResources/cumulativecohort/partials/cohortdefinitions.html'});
        $routeProvider.otherwise({redirectTo: '/cohortdefinitions'});
    }]);

cumulativecohort.factory('$data', function ($http) {
    

    var getCohortDefinitions = function () {
        return $http.get("cohortdefinitions.json");
    };
    return {

        getCohortDefinitions: getCohortDefinitions,
        
    }
});

