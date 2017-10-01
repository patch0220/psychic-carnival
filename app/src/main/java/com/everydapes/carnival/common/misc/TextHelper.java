package com.everydapes.carnival.common.misc;

import android.content.Context;
import android.support.annotation.StringRes;

public class TextHelper {
    private final Context context;

    public TextHelper(Context context) {
        this.context = context;
    }

    public String getText(@StringRes int stringResId) {
        return context.getString(stringResId);
    }

    public String getText(@StringRes int stringResId, Object... args) {
        return context.getString(stringResId, args);
    }
}
