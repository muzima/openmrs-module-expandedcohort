var expandedcohort = angular.module('expandedcohort', ['ui.bootstrap', 'filters']);

expandedcohort.
    config(['$routeProvider', '$compileProvider', function ($routeProvider, $compileProvider) {
        $compileProvider.urlSanitizationWhitelist(/^\s*(https?|ftp|mailto|file):/);
        $routeProvider.when('/cohortdefinitions', {controller: CohortDefinitionsCtrl,
            templateUrl: '../../moduleResources/expandedcohort/partials/cohortdefinitions.html'});
        $routeProvider.when('/cohortdefinition', {controller: CohortDefinitionCtrl,
            templateUrl: '../../moduleResources/expandedcohort/partials/cohortdefinition.html'});
        $routeProvider.when('/cohortdefinition/:uuid', {controller: CohortDefinitionCtrl,
            templateUrl: '../../moduleResources/expandedcohort/partials/cohortdefinition.html'});
        $routeProvider.when('/createcohortdefinition', {controller: CohortDefinitionCtrl,
            templateUrl: '../../moduleResources/expandedcohort/partials/cohortdefinition.html'});
        $routeProvider.otherwise({redirectTo: '/cohortdefinitions'});
    }]);

expandedcohort.factory('$data', function ($http) {
    

    var getCohortDefinitions = function () {
        return $http.get("cohortdefinitions.json");
    };
    var getCohortDefinition = function (uuid) {
            return $http.get("cohortdefinition.json?uuid=" + uuid);
        };
    var getAllCohorts = function () {
            return $http.get("cohorts.json");
        };
    var getAllCohortsWithoutDefinition=function(){
            return $http.get("cohortswithoutdefinition.json");
         };
    var saveCohortDefinition = function (uuid, cohortid, definition, isscheduled) {
            return $http.post("cohortdefinition.json", {"uuid": uuid, "cohortid":cohortid, "definition": definition, "isscheduled": isscheduled});
        };

    return {

        getCohortDefinitions: getCohortDefinitions,
        getCohortDefinition:getCohortDefinition,
        saveCohortDefinition:saveCohortDefinition,
        getAllCohorts:getAllCohorts,
        getAllCohortsWithoutDefinition:getAllCohortsWithoutDefinition
        
    }
});

