app.directive("myCourse", myCourse);

function myCourse(){
    return {
        restrict: 'EA',

        scope: {
            nomeCurso:'@'
        },

        // link: function(scope, element, attrs) {
        //     console.log(scope);
        //     console.log(element);
        //     console.log(attrs);
        // },

        templateUrl: "/elements/course.template.html"
    };
};