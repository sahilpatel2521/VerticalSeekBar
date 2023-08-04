package com.example.verticalseekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.SeekBar;

import androidx.core.content.ContextCompat;

@SuppressLint("AppCompatCustomView")
public class CustomVerticalSeekBar extends SeekBar {

    private OnVerticalSeekBarChangeListener listener;

    public CustomVerticalSeekBar(Context context) {
        super(context);
        initView(context);
    }

    public CustomVerticalSeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public CustomVerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);

    }

    public CustomVerticalSeekBar(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);

    }

    private void initView(Context context) {
        // Set Custom Progress Bar Drawable
        setProgressDrawable(ContextCompat.getDrawable(context, R.drawable.vertical_progress_selector));
        // Set Custom Thumb
        setThumb(ContextCompat.getDrawable(context, R.drawable.thumb));

    }

    @Override
    public synchronized void setMax(int max) {
        super.setMax(max);
    }

    @Override
    public synchronized void setMin(int min) {
        super.setMin(min);
    }

    @Override
    protected synchronized void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(heightMeasureSpec, widthMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        canvas.rotate(-90f);
        canvas.translate(-getHeight(), 0f);
        canvas.translate(getPaddingTop(), getPaddingLeft()); // Add this line
        super.onDraw(canvas);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return true;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                setProgress(getMax() - (getMax() * (int) event.getY() / getHeight()));
                float volume = getMax() - (getMax() * (int) event.getY() / getHeight());
                Log.d("TAG", "onTouchEvent: "+volume);
                listener.onStopTrackingTouch(this, volume);
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

    public void setSeekBarThumb(Context context, Drawable thumb) {
        super.setThumb(thumb);

        if (thumb != null) {
            if (thumb != null) {
                int thumbWidth = thumb.getIntrinsicWidth();
                int thumbHeight = thumb.getIntrinsicHeight();
                thumb.setBounds(0, 0, thumbWidth, thumbHeight);
                setThumbOffset(1);
                //            setThumb(thumb);
            }
        }

    }

    @Override
    public void setThumb(Drawable thumb) {
        super.setThumb(thumb);
    }

    @Override
    public void setThumbOffset(int thumbOffset) {
        super.setThumbOffset(thumbOffset);
    }

    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
    }

    @Override
    public Drawable getThumb() {
        return super.getThumb();
    }

    @Override
    public int getThumbOffset() {
        return super.getThumbOffset();
    }

    @Override
    public synchronized int getProgress() {
        return super.getProgress();
    }

    @Override
    public boolean isEnabled() {
        return super.isEnabled();
    }


    @Override
    public void setOnSeekBarChangeListener(OnSeekBarChangeListener l) {
        super.setOnSeekBarChangeListener(l);
    }


    @Override
    public CharSequence getAccessibilityClassName() {
        return super.getAccessibilityClassName();
    }


    public void setOnSeekBarChangeListener(OnVerticalSeekBarChangeListener onVerticalSeekBarChangeListener) {
        listener = onVerticalSeekBarChangeListener;
    }

    public interface OnVerticalSeekBarChangeListener {
        void onProgressChanged(CustomVerticalSeekBar seekBar, int progress, boolean fromUser);
        void onStartTrackingTouch(CustomVerticalSeekBar seekBar);
        void onStopTrackingTouch(CustomVerticalSeekBar seekBar, float volume);
    }

}