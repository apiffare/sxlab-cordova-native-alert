package com.nativealert.plugin;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class NativeAlert extends CordovaPlugin {

	final Context context = this.cordova.getActivity().getApplicationContext();

	@Override
	public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
		if (action.equals("alert")) {
			String message = data.getString(0);
			this.alert(message, callbackContext);
			
			callbackContext.success("success");
			return true;
		}
		callbackContext.error("error");
		
		return false;
	}
	
	private void alert(String message, CallbackContext callbackContext) {	
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		alertDialogBuilder.setTitle("Alert");

		alertDialogBuilder
			.setMessage(message)
			.setCancelable(false)
			.setNeutralButton("Ok",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					dialog.cancel();
				}
			});

			AlertDialog alertDialog = alertDialogBuilder.create();

			alertDialog.show();
		
		callbackContext.success(message);
	}
}
