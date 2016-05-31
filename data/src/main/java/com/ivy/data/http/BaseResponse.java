package com.ivy.data.http;

/**
 * Created by ivy on 2016/3/9.
 * 基本回调
 */
public class BaseResponse{
    private String resultCode;
    private String resultInfo;
    private String currentActionCode;
    private String page;
    private String data;

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public String getCurrentActionCode() {
        return currentActionCode;
    }

    public void setCurrentActionCode(String currentActionCode) {
        this.currentActionCode = currentActionCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
