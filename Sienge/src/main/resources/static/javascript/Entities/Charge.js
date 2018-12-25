/**
 * Get method to get the cost of charge in tonne
 */
 function getCharge () {
    $http({
        url: "/charge",
        method: "GET",
        params: {
            kilometer:parseInt($scope.streetPavimentadaDistance) + parseInt($scope.streetNotPavimentadaDistance),
            weight:$scope.chargeWeigth
        }
    }).then(
        function(response) {
            $scope.chargeWeigthCost = response.data;
            $scope.$watch('chargeWeigthCost', function () {
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
}