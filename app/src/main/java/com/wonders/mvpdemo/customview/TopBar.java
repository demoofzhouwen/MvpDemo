package com.wonders.mvpdemo.customview;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easyandroidanimations.library.RotationAnimation;
import com.wonders.mvpdemo.R;

/**
 *
 */
public class TopBar extends RelativeLayout {

    private int mLeftTextColor;
    private Drawable mLeftBackground;
    private String mLeftText;
    private int mRightTextColor;
    private Drawable mRightBackground;
    private String mRightText;
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mTitle;
    private LayoutParams mLeftParams;
    private LayoutParams mRightParams;
    private LayoutParams mTitleParams;
    private ImageView mLeftButton;
    private ImageView mRightButton;
    private TextView mTitleView;
    private TopBarClickListener mListener;
    private Context context;

    public TopBar(Context context) {
        super(context);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        getAttribute(context,attrs);
        addCustomView(context);
        this.context=context;
        setListener();

    }

    /**
     *
     * @param id id==0 表示左边的Button
     * @param flag 是否显示
     */
    public void setButtonVisable(int id,boolean flag){
        if(flag){
            if(id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else {
            if(id==0){
                mLeftButton.setVisibility(View.GONE);
            }else {
                mRightButton.setVisibility(View.GONE);
            }

        }
    }
    //暴露一个方法给调用这来注册接口回调
    //通过回调来获得回调者对接口方法的实现
    public void setmListener(TopBarClickListener mListener) {
        this.mListener = mListener;
    }

    private void setListener( ) {
        mLeftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    new RotationAnimation(mLeftButton).setPivot(RotationAnimation.PIVOT_CENTER).animate();
                    mListener.leftClick(v);
                }
            }
        });
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mListener!=null){
                    mListener.rightClick(v);
                }
            }
        });
    }




    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void addCustomView(Context context) {
        mLeftButton = new ImageView(context);
        mRightButton = new ImageView(context);
        mTitleView = new TextView(context);

        //mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        //mLeftButton.setText(mLeftText);

        //mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        //mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTitleTextColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组建设置相应的布局元素
        mLeftParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int leftPx = dip2px(context, 15);
        int topPx = dip2px(context, 6);
        mLeftParams.setMargins(leftPx,topPx,0,topPx);
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        mLeftParams.addRule(RelativeLayout.CENTER_VERTICAL,TRUE);
        mLeftButton.setPadding(0,80,0,80);
        mLeftButton.setLayoutParams(mLeftParams);
        addView(mLeftButton,mLeftParams);

        mRightParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int leftPx2 = dip2px(context, 15);
        int topPx2 = dip2px(context, 6);
        mRightParams.setMargins(0,topPx2,leftPx2,topPx2);
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        mRightButton.setPadding(0,80,0,80);
        addView(mRightButton,mRightParams);

        mTitleParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        int dplr = dip2px(context, 12);
        mTitleParams.setMargins(dplr,0,dplr,0);
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleParams);

    }

    public TopBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void getAttribute(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_LeftTextColor, 0);
        mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_LeftBackground);
        mLeftText = typedArray.getString(R.styleable.TopBar_LeftText);

        mRightTextColor = typedArray.getColor(R.styleable.TopBar_RightTextColor, 0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_RightBackground);
        mRightText = typedArray.getString(R.styleable.TopBar_RightText);

        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_TitleTextSiza, 10);
        mTitleTextColor = typedArray.getColor(R.styleable.TopBar_TitleTextColor, 0);
        mTitle = typedArray.getString(R.styleable.TopBar_TopBarTitle);

        //获取完TypeArray的值后，一般要调用recycle方法来避免创建的时候的错误
        typedArray.recycle();

    }
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public  int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
