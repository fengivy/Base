package com.ivy.dakache.base;

import android.os.Bundle;

/**
 * Created by ivy on 2016/5/31.
 */
public class BasePresenter<V extends BaseView> {
    private V baseView;

    public BasePresenter(V baseView){
        this.baseView=baseView;
    }

    private V getView(){
        return baseView;
    }

    private BaseActivity getCurrentActivity(){
        return getView().getCurrentActivity();
    }


    private Bundle getBundle(){
        return getView().getBundle();
    }
}
