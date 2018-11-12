package com.annarm.douban.moive.network;

import okhttp3.*;

import java.io.IOException;
import java.util.TreeMap;

/**
 * description:
 *
 * @author wangzhijun
 * date 2018/8/30 14:20
 * @version V1.0
 */
public class HttpParamInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request oldRequest = chain.request();
        Request.Builder newRequestBuild = oldRequest.newBuilder();
        String method = oldRequest.method();
        FormBody newFormBody = null;
        if("POST".equals(method)) {
            RequestBody oldBody = oldRequest.body();
            if (oldBody instanceof FormBody) {
                FormBody oldFromBody = (FormBody)oldBody;
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                int size = oldFromBody.size();
                TreeMap<String, String> treeMap = new TreeMap<>();
                for (int i = 0; i < size; i++) {
                    String name = oldFromBody.name(i);
                    String value = oldFromBody.value(i);
                    treeMap.put(name, value);
                    formBodyBuilder.add(name, value);
                }
                injectCommonParams(formBodyBuilder, treeMap);
                newFormBody = formBodyBuilder.build();
            }
        }
        newRequestBuild
                .addHeader("Content-Type", "text/html; charset=UTF-8")
                .addHeader("Connection", "keep-alive")
                .addHeader("Accept", "*/*")
                .addHeader("Accept-Encoding", "Vary");
        if (newFormBody != null) newRequestBuild.post(newFormBody);
        Request request = newRequestBuild.build();
        return chain.proceed(request);
    }

    private void injectCommonParams(FormBody.Builder formBodyBuilder, TreeMap<String, String> treeMap) {

    }
}
