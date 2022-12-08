package com.jed.lib.easyview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;


/**
 * 自定义View
 * 1. 圆角, 不能切到子元素的越界,如果要控制子元素,建议用cardView
 * 2. 边框
 * 3. 渐变
 * 4. 各种点击事件, 节流
 */
public class BaseEasy {
    private static final String TAG = "BaseEasy";

    private GradientDrawable gradientDrawable;

    private float leftTopRadius;
    private float rightTopRadius;
    private float leftBottomRadius;
    private float rightBottomRadius;
    private float radius;

    public void initView(View view, Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.EasyView);

        radius = array.getDimension(R.styleable.EasyView_ev_radius, 0);
        leftTopRadius = array.getDimension(R.styleable.EasyView_ev_left_top_radius, radius);
        leftBottomRadius = array.getDimension(R.styleable.EasyView_ev_left_bottom_radius, radius);
        rightTopRadius = array.getDimension(R.styleable.EasyView_ev_right_top_radius, radius);
        rightBottomRadius = array.getDimension(R.styleable.EasyView_ev_right_bottom_radius, radius);

        int bgColor = array.getColor(R.styleable.EasyView_ev_bg_color, 0);
        int[] colors = new int[]{bgColor, bgColor};
        float[] radiosColors = new float[]{leftTopRadius, leftTopRadius, rightTopRadius, rightTopRadius, rightBottomRadius, rightBottomRadius, leftBottomRadius, leftBottomRadius};
        gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, colors);
        gradientDrawable.setCornerRadii(radiosColors);

        view.setBackground(gradientDrawable);
        array.recycle();
    }
}
