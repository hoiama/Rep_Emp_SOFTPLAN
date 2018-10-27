app.factory('restMethodsVehicleFactory', restMethodsVehicleFactory);

function restMethodsVehicleFactory($resource){
    return $resource("/vehicle/:id", null, {
        update : {
            method :'PUT'
        }
    });
}

