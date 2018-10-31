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

// function myModel (Translator) {
//     return {
//         restrict: 'A', // Restrict directive to attribute
//         scope: {
//             translate: '@' // The key/string to be translated
//         },
//         controller: ['$scope', 'Translator', // Inject Translator, a service that I created down below that handles the translations.
//             function ($scope, Translator) {
//                 $scope.translated = Translator.translate($scope.translate);
//             }
//         ],
//         link: function (scope, element, attrs) {
//             attrs.placeholder = scope.translated;
//         }
//     };
// };

