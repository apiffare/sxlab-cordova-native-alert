/*global cordova, module*/

module.exports = {
    alert: function (msg, successCallback, errorCallback) {
		alert("trying exec");
        cordova.exec(successCallback, errorCallback, "NativeAlert", "alert", [msg]);
    }
};
