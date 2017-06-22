package com.electricdrewbaloogmail.pomodoroendofday;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.math.BigDecimal;

import java.lang.reflect.Field;

import static android.R.attr.type;
import static java.lang.Double.parseDouble;


/**
 * Created by drewdyer-symonds on 6/15/17.
 */

public class Tools {



    public static BigDecimal parseBD(Context context, String id) {

        View rootView = ((Activity)context).getWindow().getDecorView().findViewById(android.R.id.content);

        int resID = getId(id, R.id.class);
        EditText editText = (EditText) rootView.findViewById(resID);
        // Verify that editTest contains a number, return 0 otherwise
        String text = editText.getText().toString();
        try {
            Double number = Double.parseDouble(text);
            return new BigDecimal(number);
        } catch (NumberFormatException e) {
            return new BigDecimal(0);
        }
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

}
