package com.jed.lib.easyview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class EasyRelativeLayout extends RelativeLayout {
    private BaseEasy customView = new BaseEasy();
    public EasyRelativeLayout(@NonNull Context context) {
        this(context, null);
    }

    public EasyRelativeLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        customView.initView(this, context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        customView.draw(canvas);
        super.onDraw(canvas);
        customView.drawBorder(canvas);
    }
}
