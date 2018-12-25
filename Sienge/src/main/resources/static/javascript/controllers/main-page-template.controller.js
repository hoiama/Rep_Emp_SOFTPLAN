(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "resourceVehicleFactory", "resourceChargeFactory"];

    function MainPageTemplateController($scope, $filter, $http, resourceVehicleFactory, resourceChargeFactory) {

        $scope.selectedVehicle;
        $scope.availableOptions = [
            {name:"Caminhão baú", value:"bau"},
            {name:"Caminhão caçamba", value:"cacamba"},
            {name:"Caminhão carreta", value:"carreta"}
        ];
        $scope.chargeWeigth = 0;
        $scope.chargeWeigthCost = 0;
        $scope.vehicleCost = 0;
        $scope.totalCost = 0;
        $scope.placeholder3 = 100;

    }
})()