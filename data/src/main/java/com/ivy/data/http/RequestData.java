package com.ivy.data.http;

/**
 * Created by ivy on 2016/3/10.
 * 如果有分页的话，初始化时请设置page的值
 */
public abstract class RequestData {
    protected String page="";
    public abstract String getActionCode();

    public abstract String getMethod();

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
