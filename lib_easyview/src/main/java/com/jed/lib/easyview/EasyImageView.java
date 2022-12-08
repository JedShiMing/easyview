package com.jed.lib.easyview;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

public class EasyImageView extends AppCompatImageView {
    private BaseEasy customView = new BaseEasy();
    public EasyImageView(@NonNull Context context) {
        this(context, null);
    }

    public EasyImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        customView.initView(this, context, attrs);
    }
}
