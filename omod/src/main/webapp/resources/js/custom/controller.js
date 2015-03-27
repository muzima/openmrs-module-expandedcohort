function CohortDefinitionsCtrl($scope, $location, $data){
$data.getCohortDefinitions().
        then(function (response) {
            var serverData = response.data;
            $scope.cohortdefinitions = serverData.objects;
            $scope.noOfPages =1;
        });
}
function CohortDefinitionCtrl($scope, $routeParams, $location, $data){
    $scope.cohortdefinition = {};
    // initialize the view to be read only
    $scope.mode = "view";
    $scope.uuid = $routeParams.uuid;

    if ($scope.uuid === undefined) {
        $scope.mode = "edit";
        $data.getAllCohortsWithoutDefinition().
            then(function (response) {
                var serverData = response.data;
                $scope.cohorts = serverData.objects;
            });
    } else {
        $data.getCohortDefinition($scope.uuid).
            then(function (response) {
                $scope.cohortdefinition = response.data;
                console.log("response.dada: "+JSON.stringify(response.data));
            });
        $data.getAllCohorts().
            then(function (response) {
                var serverData = response.data;
                $scope.cohorts = serverData.objects;
            });
    }

    $scope.edit = function () {
        $scope.mode = "edit";
    };

    $scope.cancel = function () {
        if ($scope.mode == "edit") {
            if ($scope.uuid === undefined) {
                $location.path("/cohortdefinitions");
            } else {
                $scope.mode = "view"
            }
        } else {
            $location.path("/cohortdefinitions");
        }
    };

    $scope.save = function (cohortdefinition) {
        if(cohortdefinition.isscheduled===undefined){
            cohortdefinition.isscheduled=false;
        }
        $data.saveCohortDefinition(cohortdefinition.uuid,cohortdefinition.cohortid, cohortdefinition.definition, cohortdefinition.isscheduled).
            then(function () {
                $location.path("/cohortdefinitions");
            })
    };

    $scope.delete = function () {
        $data.deleteSource($scope.uuid).
            then(function () {
                $location.path("/cohortdefinitions");
            })
    };
    $scope.cohortselected = function(cohortdefinition,cohorts){
                angular.forEach(cohorts,function(cohort,key){
                    if(cohortdefinition.cohortid==cohort.id){
                        cohortdefinition.description = cohort.description;
                        $scope.definitioninputdisabled=function(e){

                            console.log("cohort description : "+cohort.description);
                            return false;
                         };
                    }
                });

    }
    $scope.definitioninputdisabled=function(uuid){
        if(uuid){return false; }else{return true; }
    };
}

