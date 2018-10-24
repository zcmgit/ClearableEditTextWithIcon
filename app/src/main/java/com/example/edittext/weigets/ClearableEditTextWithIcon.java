package com.example.edittext.weigets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.edittext.R;


public class ClearableEditTextWithIcon extends AppCompatEditText implements TextWatcher, View.OnTouchListener,
        View.OnFocusChangeListener {

    private Drawable right;

//    public ClearableEditTextWithIcon(Context context) {
//        super(context);
//        init();
//    }

    public ClearableEditTextWithIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ClearableEditTextWithIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs);
    }

//    private void init(){
//        right = getResources().getDrawable(R.mipmap.clean_icon);
//        addTextChangedListener(this);
//        setOnFocusChangeListener(this);
//        setOnTouchListener(this);
//    }
    private void init(Context context,AttributeSet attrs){
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.custom_edit);
        right = typedArray.getDrawable(R.styleable.custom_edit_icon);
        if(right == null){
            right = getResources().getDrawable(R.mipmap.clean_icon);
        }
        addTextChangedListener(this);
        setOnFocusChangeListener(this);
        setOnTouchListener(this);
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (event.getX() > getWidth() - getPaddingRight() - right.getIntrinsicWidth() && null != getCompoundDrawables()[2]) {
                setText("");
            }
        }
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() > 0 && hasFocus())
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
        else
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
    }

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus && getText().length() > 0){
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], right, getCompoundDrawables()[3]);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(getCompoundDrawables()[0], getCompoundDrawables()[1], null, getCompoundDrawables()[3]);
        }
    }

}
