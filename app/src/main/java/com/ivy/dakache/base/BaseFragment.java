package com.ivy.dakache.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ivy.common.log.LogUtils;

/**
 * Created by ivy on 2016/5/31.
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView{
    private P mPresenter;
    private String tag=this.getClass().getName();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initPresenter();
        View view=inflater.inflate(getLayoutResourceId(),null);
        findViewById();
        initListener();
        init();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

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

    protected abstract int getLayoutResourceId();

    protected abstract void findViewById();

    protected abstract void init();

    protected abstract void initListener();

    protected abstract void initPresenter();

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.v(tag, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.v(tag, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.v(tag, "onStop");
    }

    @Override
    public void onStart() {
        super.onStart();
        LogUtils.v(tag, "onStart");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.v(tag, "onDestroy");
    }

    @Override
    public Bundle getBundle() {
        return getArguments();
    }

    @Override
    public BaseActivity getCurrentActivity() {
        return getCurrentActivity();
    }
}
