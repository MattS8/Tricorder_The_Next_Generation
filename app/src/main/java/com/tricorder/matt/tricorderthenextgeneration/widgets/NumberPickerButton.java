package com.tricorder.matt.tricorderthenextgeneration.widgets;

/**
 * Created by Matt on 5/25/2015.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.ImageButton;

import com.tricorder.matt.tricorderthenextgeneration.R;

/**
 * This class exists purely to cancel long click events, that got
 * started in NumberPicker
 */
class NumberPickerButton extends ImageButton {

    private NumberPicker mNumberPicker;

    public NumberPickerButton(Context context, AttributeSet attrs,
                              int defStyle) {
        super(context, attrs, defStyle);
    }

    public NumberPickerButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NumberPickerButton(Context context) {
        super(context);
    }

    public void setNumberPicker(NumberPicker picker) {
        mNumberPicker = picker;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        cancelLongpressIfRequired(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onTrackballEvent(MotionEvent event) {
        cancelLongpressIfRequired(event);
        return super.onTrackballEvent(event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
                || (keyCode == KeyEvent.KEYCODE_ENTER)) {
            cancelLongpress();
        }
        return super.onKeyUp(keyCode, event);
    }

    private void cancelLongpressIfRequired(MotionEvent event) {
        if ((event.getAction() == MotionEvent.ACTION_CANCEL)
                || (event.getAction() == MotionEvent.ACTION_UP)) {
            cancelLongpress();
        }
    }

    private void cancelLongpress() {
        if (R.id.increment == getId()) {
            mNumberPicker.cancelIncrement();
        } else if (R.id.decrement == getId()) {
            mNumberPicker.cancelDecrement();
        }
    }
}