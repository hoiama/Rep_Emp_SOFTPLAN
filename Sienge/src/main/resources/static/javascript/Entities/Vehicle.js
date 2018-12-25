/**
 * Get method to get the cost of vehicle used in transport of charge
 */
function getVehicleCost () {
    $http({
        url: "/vehicle",
        method: "GET",
        params: {typeVehicle:$scope.selectedVehicle,costWithKilometer:parseInt($scope.streetTotalCostPavimentada) + parseInt($scope.streetTotalCostNaoPavimentada)}
    }).then(
        function(response) {
            $scope.vehicleCost = response.data;
            $scope.$watch('vehicleCost', function () {
                $scope.totalCost = 0;
                $scope.totalCost =
                    $scope.streetTotalCostPavimentada+
                    $scope.streetTotalCostNaoPavimentada+
                    $scope.chargeWeigthCost+
                    $scope.vehicleCost;
            });
        },
        function(error) {
            console.log(response);
        });
};