(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "resourceVehicleFactory", "resourceChargeFactory"];

    function MainPageTemplateController($scope, $filter, $http, resourceVehicleFactory, resourceChargeFactory) {
        $scope.streetPavimentadaDistance = 0;
        $scope.streetNotPavimentadaDistance = 0;
        $scope.chargeWeigth = 0;
        $scope.selectedVehicle;
        $scope.availableOptions = [
            {name:"Caminhão baú", value:"bau"},
            {name:"Caminhão caçamba", value:"cacamba"},
            {name:"Caminhão carreta", value:"carreta"}
        ];
        $scope.streetTotalCostPavimentada = 0;
        $scope.streetTotalCostNaoPavimentada = 0;
        $scope.chargeWeigthCost = 0;
        $scope.vehicleCost = 0;
        $scope.totalCost = 0;

        $scope.getStreetPavimentada = function () {
            if($scope.costForm.$invalid){return;}
            $http({
                url: "/street/pavimentada",
                method: "GET",
                params: {kilometer: parseInt($scope.streetPavimentadaDistance)}

            }).then(
                function (response) {
                   $scope.streetTotalCostPavimentada = response.data;
                   $scope.$watch('streetTotalCostPavimentada', function () {
                       $scope.totalCost = 0;
                       $scope.totalCost =
                           $scope.streetTotalCostPavimentada+
                           $scope.streetTotalCostNaoPavimentada+
                           $scope.chargeWeigthCost+
                           $scope.vehicleCost;
                   });
                },
                function (error) {
                    console.log(response);
                });
        }


        $scope.getStreetNaoPavimentada = function () {
            $http({
                url: "/street/nao-pavimentada",
                method: "GET",
                params:{kilometer:parseInt($scope.streetNotPavimentadaDistance)}

            }).then(
                function(response) {
                    $scope.streetTotalCostNaoPavimentada = response.data;
                    $scope.$watch('streetTotalCostPavimentada', function () {
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


        $scope.getCharge = function () {
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
                    $scope.$watch('streetTotalCostPavimentada', function () {
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


        $scope.getVehicleCost =  function () {
                $http({
                    url: "/vehicle",
                    method: "GET",
                    params: {typeVehicle:$scope.selectedVehicle,costWithKilometer:parseInt($scope.streetTotalCostPavimentada) + parseInt($scope.streetTotalCostNaoPavimentada)}
                }).then(
                    function(response) {
                        $scope.vehicleCost = response.data;
                        $scope.$watch('streetTotalCostPavimentada', function () {
                            //$scope.vehicleCost = response.data;
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


        //METODO RESOURCE COM PROBLEMAS NO RETORNO, SUBSTITUIR POR $HTTP
        // $scope.getCharge = function(){
        //
        //     resourceChargeFactory
        //         .get({
        //                 kilometer:parseInt($scope.streetPavimentadaDistance) + parseInt($scope.streetNotPavimentadaDistance),
        //                 weight:$scope.chargeWeigth
        //             },
        //             function (response) {
        //                 $scope.chargeWeigthCost = response.response;
        //                 console.log(response);
        //                 console.log(response.status);
        //                 console.log(response.toString());
        //                 console.log(response.response);
        //                 console.log(response.data);
        //                 console.log(response.content);
        //
        //             },
        //             function (error) {
        //                 console.log(error);
        //             });
        //
        //     }


    }

})()