package com.everydapes.carnival.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

public class DialogUtils {

    /**
     * Create dialog
     *
     * @param context
     * @param title
     * @param message
     * @param positiveBtnName
     * @return
     */
    public static Dialog createDialog(Context context, String title, String message, String positiveBtnName) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveBtnName, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        return builder.create();
    }

    public static Dialog createDialog(Context context, String title, String message, String positiveBtnName, String negativeBtnName,
                                      DialogInterface.OnClickListener positiveOnClickListener, DialogInterface.OnClickListener negativeOnClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveBtnName, positiveOnClickListener)
                .setNegativeButton(negativeBtnName, negativeOnClickListener);

        return builder.show();
    }
}
