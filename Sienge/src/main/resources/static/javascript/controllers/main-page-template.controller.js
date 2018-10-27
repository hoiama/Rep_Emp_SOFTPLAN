(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "restMethodsVehicleFactory"];

    function MainPageTemplateController($scope, $filter, $http, restMethodsVehicleFactory) {
        $scope.streetPavimentadaDistance = "";
        $scope.streetNotPavimentadaDistance = "";
        $scope.streets = {};
        $scope.selectedVehicle = "";
        $scope.vehicleCost = "";
        $scope.chargeWeigth = "";



        $scope.PostVehicle = function(id){
            restMethodsVehicleFactory
                .save({"typeVehicle": "Caminhão caçamba"},
                    function (cursosReturn) {
                        $scope.vehicleCost = cursosReturn.response.data.post;
                        $scope.vehicleCost = cursosReturn.response.data;
                        console.log(cursosReturn);
                    }),

                function (error) {
                    console.log(error);
                }
        }


    }
})()