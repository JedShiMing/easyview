package com.jed.lib.easyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;

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

    @Override
    protected void onDraw(Canvas canvas) {
        customView.draw(canvas);
        super.onDraw(canvas);
    }
}
