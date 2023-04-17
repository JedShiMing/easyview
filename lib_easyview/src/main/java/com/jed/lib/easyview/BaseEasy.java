package com.jed.lib.easyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;


/**
 * 自定义View
 * 1. 圆角
 * 2. 边框
 * 3. 渐变
 * 4. 各种点击事件, 节流
 */
public class BaseEasy {
    private static final String TAG = BaseEasy.class.getName();

    private View mView;
    private GradientDrawable gradientDrawable;

    private Paint paint;
    private RectF rectF;
    private float[] radii;

    // 圆角
    private float leftTopRadius;
    private float rightTopRadius;
    private float leftBottomRadius;
    private float rightBottomRadius;
    private float radius;
    // 是否裁剪,子组件超出父组件的时候需要
    private boolean overflow;
    // 边框
    private int strokeColor;
    private float strokeWidth;

    public void initView(View view, Context context, AttributeSet attrs) {
        paint = new Paint();
        paint = new Paint();
        paint.setAntiAlias(true);
        rectF = new RectF();
        rectF = new RectF();

        this.mView = view;
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EasyView);

        radius = array.getDimension(R.styleable.EasyView_ev_radius, 0);
        leftTopRadius = array.getDimension(R.styleable.EasyView_ev_left_top_radius, radius);
        leftBottomRadius = array.getDimension(R.styleable.EasyView_ev_left_bottom_radius, radius);
        rightTopRadius = array.getDimension(R.styleable.EasyView_ev_right_top_radius, radius);
        rightBottomRadius = array.getDimension(R.styleable.EasyView_ev_right_bottom_radius, radius);
        strokeColor = array.getColor(R.styleable.EasyButton_ev_stroke_color, Color.TRANSPARENT);
        strokeWidth = array.getDimension(R.styleable.EasyButton_ev_stroke_width, 0f);

        overflow = array.getBoolean(R.styleable.EasyView_ev_overflow, false);

        radii = new float[]{leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius, rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};

        if (!overflow) {
            int bgColor = array.getColor(R.styleable.EasyView_ev_bg_color, 0);
            int[] colors = new int[]{bgColor, bgColor};
            gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
            gradientDrawable.setCornerRadii(radii);
            view.setBackground(gradientDrawable);
        }

        array.recycle();
    }

    public void draw(Canvas canvas) {
        if (overflow) {
            rectF.set(0, 0, mView.getWidth(), mView.getHeight());
            Path path = new Path();
            path.addRoundRect(rectF, radii, Path.Direction.CW);
            canvas.clipPath(path);
        }
        drawBorder(canvas);
    }

    private void drawBorder(Canvas canvas) {
        if (strokeWidth > 0f && strokeColor != Color.TRANSPARENT) {
            paint.setColor(strokeColor);
            paint.setStrokeWidth(strokeWidth);
            paint.setStyle(Paint.Style.STROKE);
            Path path = new Path();
            path.addRoundRect(rectF, radii, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }
    }

}
