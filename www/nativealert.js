/*global cordova, module*/

module.exports = {
    nalert: function (msg, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "NativeAlert", "alert", [msg]);
    }
};
