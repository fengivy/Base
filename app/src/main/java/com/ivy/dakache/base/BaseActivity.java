package com.ivy.dakache.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ivy.common.log.LogUtils;

/**
 * Created by ivy on 2016/5/31.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements BaseView{
    private P mPresenter;
    private String tag=this.getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtils.v(tag, "onCreate");
        initPresenter();
        setContentView(getLayoutResourceId());
        findViewById();
        initListener();
        init();
    }

    protected abstract int getLayoutResourceId();

    protected abstract void findViewById();

    protected abstract void init();

    protected abstract void initListener();

    protected abstract void initPresenter();

    /**
     * 获取presenter
     * @return
     */
    private P getPresenter(){
        if (mPresenter==null){
            synchronized (this){
                if (mPresenter==null)
                    initPresenter();
            }
        }
        return mPresenter;
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.v(tag,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.v(tag, "onPause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.v(tag, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.v(tag, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.v(tag, "onDestroy");
    }

    @Override
    public BaseActivity getCurrentActivity() {
        return this;
    }

    @Override
    public Bundle getBundle() {
        return getIntent().getExtras();
    }
}
