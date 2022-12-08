package com.jed.lib.easyview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EasyLinearLayout extends LinearLayout {
    private BaseEasy customView = new BaseEasy();
    public EasyLinearLayout(@NonNull Context context) {
        this(context, null);
    }

    public EasyLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        customView.initView(this, context, attrs);
    }
}
