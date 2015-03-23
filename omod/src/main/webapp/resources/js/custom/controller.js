function CohortDefinitionsCtrl($scope, $location, $data){
$data.getCohortDefinitions().
        then(function (response) {
            var serverData = response.data;
            $scope.cohortdefinitions = serverData.objects;
            $scope.noOfPages =1;
        });
}


