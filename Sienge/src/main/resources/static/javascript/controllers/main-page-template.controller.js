(function () {
    "use strict";

    app.controller("MainPageTemplateController", MainPageTemplateController);

    MainPageTemplateController.$inject =["$scope", "$filter", "$http", "restMethodsFactoryCurso", "restMethodsFactoryFormacao"];

    function MainPageTemplateController($scope, $filter, $http, restMethodsFactoryCurso, restMethodsFactoryFormacao) {
        $scope.cursos = [];
        $scope.experiencias = [];
        $scope.formacoes =[];
        $scope.resumes = [];
        $scope.curriculos = [];

        $scope.testeCurso = 'testecurso';

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



        /**
         * Get de formacao usando factory:"FactoryMethodsRest" criada.
         * URL: /formacao/:idCurso
         */
        $scope.getFormacoes = function () {
            restMethodsFactoryFormacao
                .get({id:id},
                    function (formacoesReturn) {
                        console.log(formacoesReturn);
                    }),

                function (error) {
                    console.log(error);
                }
        }

    }
})()