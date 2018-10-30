app.factory('resourceVehicleFactory', resourceVehicleFactory);

function resourceVehicleFactory($resource){

    let url = "/vehicle/:id";
    let params = {kilometer: "@id", weight:"@id"};
    let actions = { update: { method: 'PUT' } };

    return $resource(url, params, actions);
}

