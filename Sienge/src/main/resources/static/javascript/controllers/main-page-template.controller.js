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

        $scope.placeholder3 = 100;

        /**
         * Get method to get the cost of paved street
         */
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


        /**
         * Get method to get the cost of Not paved street
         */
        $scope.getStreetNaoPavimentada = function () {
            $http({
                url: "/street/nao-pavimentada",
                method: "GET",
                params:{kilometer:parseInt($scope.streetNotPavimentadaDistance)}

            }).then(
                function(response) {
                    $scope.streetTotalCostNaoPavimentada = response.data;
                    $scope.$watch('streetTotalCostNaoPavimentada', function () {
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


        /**
         * Get method to get the cost of charge in tonne
         */
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


        /**
         * Get method to get the cost of vehicle used in transport of charge
         */
        $scope.getVehicleCost =  function () {
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


        //Method with problem in retorn of request, I will use the  $HTTP now.
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