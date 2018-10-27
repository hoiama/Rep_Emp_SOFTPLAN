app.factory('resourceChargeFactory', resourceChargeFactory);

function resourceChargeFactory($resource){

    let url = "/charge/:id";
    let params = {kilometer: "@id", weight:"@id"};
    let actions = {
        update: { method: 'PUT' } ,
        post: {method:'POST', headers: [{'Content-Type': 'application/json'}]},
        get: {method:'GET', headers: [{'Content-Type': 'application/json'}]}
    };

    return $resource(url, params, actions);
}

