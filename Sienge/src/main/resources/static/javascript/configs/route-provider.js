app.config(routeProvider);

routeProvider.$inject = ["$routeProvider", "$locationProvider"];

function routeProvider($routeProvider,  $locationProvider ) {
    $routeProvider
        .when("/", {
            controller:"MainPageTemplateController",
            templateUrl:"templates/main-page.template.html"
        }).otherwise({
            redirectTo:"/"
        });

}