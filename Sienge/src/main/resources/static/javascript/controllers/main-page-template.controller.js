(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "resourceVehicleFactory", "resourceChargeFactory"];

    function MainPageTemplateController($scope, $filter, $http, resourceVehicleFactory, resourceChargeFactory) {
        $scope.streetPavimentadaDistance = 0;
        $scope.streetNotPavimentadaDistance = 0;
        $scope.streetTotalDistance = $scope.streetPavimentadaDistance + $scope.streetNotPavimentadaDistance;
        $scope.streets = 0;
        $scope.selectedVehicle = "Veículo";
        $scope.vehicleCost = 0;
        $scope.chargeWeigth = 0;

        $scope.chargeWeigthCost = 0;



        $scope.getVehicle = function(id){
            resourceVehicleFactory
                .get({id:id},
                    function (cursosReturn) {
                        $scope.vehicleCost = cursosReturn.response.data.post;
                        $scope.vehicleCost = cursosReturn.response.data;
                        console.log(cursosReturn);
                    }),

                function (error) {
                    console.log(error);
                }
        }


        $scope.findCharge = function(){
            resourceChargeFactory
                .get({kilometer:$scope.streetTotalDistance, weight:$scope.chargeWeigth},
                    function (cursosReturn) {
                        $scope.chargeWeigthCost = cursosReturn.response;
                        console.log(cursosReturn);
                        console.log(cursosReturn.response);
                        console.log(cursosReturn.valueOf);

                    }),

                function (error) {
                    console.log(error);
                }
        }

    }
})()