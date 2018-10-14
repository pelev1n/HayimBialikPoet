package com.andrewxa.hayimbialikpoet.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class Util {
    public static void setFont(Context mContext, TextView textView) {
        Typeface myFont = Typeface.createFromAsset(mContext.getAssets(), "fonts/shmulikclm.ttf");
        textView.setTypeface(myFont);
    }

    public static int getJsonPath(Context mContext, String jsonName) {
        int rawResourceId = mContext.getResources().getIdentifier(jsonName, "raw", mContext.getPackageName());
        return rawResourceId;
    }
}
