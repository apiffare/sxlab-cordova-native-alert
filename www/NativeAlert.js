/*global cordova, module*/

module.exports = {
    alert: function (msg, successCallback, errorCallback) {
        cordova.exec(successCallback, errorCallback, "NativeAlert", "alert", [msg]);
    }
};
