package com.ivy.dakache.common.http;

import com.alibaba.fastjson.JSON;
import com.ivy.data.http.BaseRequest;
import com.ivy.data.http.BaseResponse;
import com.ivy.data.http.RequestData;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by ivy on 2016/3/10.
 */
public class HttpUtils {



   /* public static <T extends RequestData> Subscription requestHouse(T request, BaseObserver<BaseResponse> responseObservable) {
        return RetrofitUtils.createApi(BaseApi.class)
                .postHouse(getRequestBody(request))
                .compose(new DealTransformer())
                .subscribe(responseObservable);
    }*/


    public static BaseRequest getBaseRequest(RequestData requestData) {
        BaseRequest baseRequest = new BaseRequest();
        baseRequest.setTimestamp(System.currentTimeMillis());
        baseRequest.setSecretKey("");
        //baseRequest.setUdid(AppUtils.getUDID(AppManager.getApplication()));
        //baseRequest.setUserId(UserManager.getUserId() + "");
        // baseRequest.setUserId("3");
        baseRequest.setServerVersion("1");
        //baseRequest.setSessionToken(UserManager.getSessionToken());
        //baseRequest.setAppVersion(AppUtils.getVersionName(AppManager.getApplication()));
        if (requestData != null) {
            baseRequest.setActionCode(requestData.getActionCode());
            baseRequest.setMethod(requestData.getMethod());
            baseRequest.setData(requestData);
            baseRequest.setPage(requestData.getPage());
        }
        return baseRequest;
    }

    public static Map<String, RequestBody> getUploadRequest(HashMap<String, String> fileMap) {
        BaseRequest baseRequest = getBaseRequest(null);
        HashMap<String, RequestBody> params = new HashMap<>();
        Iterator iter = fileMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            File file = new File(entry.getValue().toString());
            String filename = file.getName();
            RequestBody photo = RequestBody.create(MediaType.parse("multipart/form-data"), file);
            params.put("name\"; filename=\"" + filename, photo);
            //params.put("importFile\"; filename=\"" + filename, photo);
        }

        RequestBody json = RequestBody.create(MediaType.parse("text/plain"), JSON.toJSONString(baseRequest));
        params.put("json", json);
        return params;
    }


    /**
     * 获取转换对象类型
     *
     * @param baseResponse
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getObject(BaseResponse baseResponse, Class<T> clazz) {
        return JSON.parseObject(baseResponse.getData(), clazz);
    }

    /**
     * 获取转换List
     *
     * @param baseResponse
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(BaseResponse baseResponse, Class<T> clazz) {
        return JSON.parseArray(baseResponse.getData(), clazz);
    }
}
