(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "restMethodsFactoryCurso"];

    function MainPageTemplateController($scope, $filter, $http, restMethodsFactoryCurso) {
        $scope.streetPavimentadaDistance = 0;
        $scope.streetNotPavimentadaDistance = 0;
        $scope.selectedVehicle = 0;
        $scope.chargeWeigth = 0;

        /**
         * Get de cursos usando factory:"FactoryMethodsRest" criada.
         * URL: /curso/:idCurso
         */
        $scope.getCurso = function(id){
            restMethodsFactoryCurso
                .get({id:id},
                    function (cursosReturn) {
                        $scope.cursos = cursosReturn;
                        console.log(cursosReturn);
                    }),

                function (error) {
                    console.log(error);
                }
        }


        $scope.getCursos = function() {
            $scope.cursos = restMethodsFactoryCurso.query();
            console.log($scope.cursos);
        }


        $scope.init = function () {
            $scope.getCursos();
        };


    }
})()