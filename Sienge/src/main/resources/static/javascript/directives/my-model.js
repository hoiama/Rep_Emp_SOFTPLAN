app.directive('myModel', myModel);

function myModel() {
    return {
        restrict: 'AE',
        link: function (scope, element, attr, contr) {

            //Peguei o valo do placeholder no scope.controller e modifiquei.!!
            scope[attr.myModel] = 33
            console.log("6", scope.placeholder3 );

            //Peguei o valor do imput
            console.log("2", $( "#placeholder" ).val());
            console.log("4", attr.value);

            //Peguei  o valor do atributo passado no elemento
            console.log("5", attr.myModel);

            //Finalmente como sincronizar $wath element do html
            scope.$watch(element.html(), function(value) {
                scope[attr.myModel] = attr.value;
                console.log("placeholder3", scope.placeholder3 );
            });
        }
    };
};


