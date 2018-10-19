package com.evann.plugin.nativealert

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAlert extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("alert")) {
			String message = args.getString(0);
			this.alert(message, callbackContext);
			return true;
		}
		return false;
	}
	
	private void alert(String message, CallbackContext callbackContext) {
			
		AlertDialog.Builder builder;
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			builder = new AlertDialog.Builder(context, android.R.style.Theme_Material_Dialog_Alert);
		} else {
			builder = new AlertDialog.Builder(context);
		}
		builder.setTitle("Alert !")
		.setMessage(message)
		.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
			new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		})
		.show();
		
		callbackContext.success(message);
	}
}
