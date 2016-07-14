package com.wonders.mvpdemo.view;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.wonders.mvpdemo.R;
import com.wonders.mvpdemo.adapter.FragmentAdapter;
import com.wonders.mvpdemo.customview.TopBar;
import com.wonders.mvpdemo.customview.TopBarClickListener;
import com.wonders.mvpdemo.fragment.NewsFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TopBarClickListener {

    private ViewPager viewPager;
    private FragmentAdapter adapter;
    private ArrayList<Fragment> fragments=new ArrayList<>();
    private TopBar topBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.vp);
        topBar = (TopBar) findViewById(R.id.topBar);
        FragmentManager fragmentManager = getSupportFragmentManager();
        adapter = new FragmentAdapter(fragmentManager);
        viewPager.setAdapter(adapter);
        fragments.add(new NewsFragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        fragments.add(new Fragment());
        adapter.addFragment(fragments);
        topBar.setmListener(this);
    }


    @Override
    public void leftClick(View view) {
        showPopWindow(view);
    }

    @Override
    public void rightClick(View view) {

    }
    private void showPopWindow(View view) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.popwindow, null);
        Button button = (Button) inflate.findViewById(R.id.btnOut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.finish();
            }
        });
        PopupWindow popupWindow = new PopupWindow(inflate,
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.showAsDropDown(view,-30,12);
        popupWindow.showAsDropDown(view);
    }

}
