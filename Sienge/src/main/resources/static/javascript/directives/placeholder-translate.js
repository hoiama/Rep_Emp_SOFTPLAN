app.directive('placeholderTranslate', placeholderTranslate);

placeholderTranslate.$inject =["Translator"];

function placeholderTranslate (Translator) {
    return {
        restrict: 'A', // Restrict directive to attribute
        scope: {
            translate: '@' // The key/string to be translated
        },
        controller: ['$scope', 'Translator', // Inject Translator, a service that I created down below that handles the translations.
            function ($scope, Translator) {
                $scope.translated = Translator.translate($scope.translate);
            }
        ],
        link: function (scope, element, attrs) {
            attrs.placeholder = scope.translated;
        }
    };
};