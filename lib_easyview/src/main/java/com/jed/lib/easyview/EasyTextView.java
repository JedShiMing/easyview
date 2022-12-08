package com.jed.lib.easyview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

public class EasyTextView extends AppCompatTextView {
    private BaseEasy customView = new BaseEasy();
    public EasyTextView(@NonNull Context context) {
        this(context, null);
    }

    public EasyTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        customView.initView(this, context, attrs);
    }
}
