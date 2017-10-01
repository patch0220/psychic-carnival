package com.everydapes.carnival.common.utils;

import java.util.Locale;

public class TextUtils {

    private TextUtils() {
    }

    public static boolean isEmpty(CharSequence text) {
        return text == null || text.length() == 0;
    }

    public static String trimPhoneNumber(String phoneNumber) {
        String toBeReturned = phoneNumber + "";
        if (phoneNumber.length() > 3 && phoneNumber.contains("+")) {
            toBeReturned = toBeReturned.substring(3);
        }

        while (toBeReturned.length() > 0 && toBeReturned.indexOf("0") == 0) {
            toBeReturned = toBeReturned.substring(1);
        }
        return toBeReturned;
    }

    public static boolean validForRequiredFields(String string) {
        return !isEmpty(string) && !string.matches("^\\s*$");
    }

    public static String regularToSnakeCase(String string) {
        return string.toLowerCase(Locale.getDefault()).replace(" ", "_");
    }

    public static String generateInitials(String... strings) {
        String returnedString = "";
        for (String string : strings) {
            if (!android.text.TextUtils.isEmpty(string)) {
                returnedString += String.valueOf(string.charAt(0));
            }
        }
        return returnedString;
    }

    public static String generateInitials(String input) {
        String[] strings = input.split("\\s+");
        String returnedString = "";

        if (strings.length > 0) {
            returnedString += String.valueOf(strings[0].charAt(0)).toUpperCase();
            if (strings.length > 1) {
                returnedString += String.valueOf(strings[strings.length - 1].charAt(0)).toUpperCase();
            }
        }

        return returnedString;
    }


    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
