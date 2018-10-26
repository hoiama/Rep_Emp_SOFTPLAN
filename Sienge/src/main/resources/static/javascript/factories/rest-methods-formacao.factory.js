app.factory('restMethodsFactoryFormacao', restMethodsFactoryFormacao);

function restMethodsFactoryFormacao($resource){
    return $resource("/formacao/:id", null, {
        update : {
            method :'PUT'
        }
    });
}
