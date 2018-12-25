app.factory('Translator', function () {
        return {
            translate: function (key) {
                return YourLookUpInDictionaryMethodOrWhatever(key);
            }
        };
});