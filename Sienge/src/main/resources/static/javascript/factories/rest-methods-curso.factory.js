app.factory('restMethodsFactoryCurso', restMethodsFactoryCurso);

function restMethodsFactoryCurso($resource){
    return $resource("/curso/:id", null, {
        update : {
            method :'PUT'
        }
    });
}

