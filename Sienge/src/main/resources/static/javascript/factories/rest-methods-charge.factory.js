app.factory('resourceChargeFactory', resourceChargeFactory);

function resourceChargeFactory($resource){

    var url = "/charge/:id";
    var params = {kilometer:"@id",weight:"@id"};
    var actions = {
        update: { method: 'PUT' } ,
        post: {method:'POST', headers: [{'Content-Type': 'application/json'}]},
        get: {method:'GET', headers: [{'Content-Type': 'application/json'}]}
    };

    return $resource(url, params, actions);
}

