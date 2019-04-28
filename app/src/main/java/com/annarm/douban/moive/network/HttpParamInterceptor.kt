package com.annarm.douban.moive.network;

import okhttp3.*

/**
 * description:
 *
 * @author wangzhijun
 * date 2018/8/30 14:20
 * @version V1.0
 */
class HttpParamInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val oldRequest: Request = chain.request();
        val newRequestBuild: Request.Builder = oldRequest.newBuilder();
        val method: String = oldRequest.method();
        var newFormBody: FormBody? = null;
        if ("POST" == method) {
            val oldBody: RequestBody? = oldRequest.body();
            if (oldBody is FormBody) {
                val oldFromBody: FormBody = oldBody;
                val formBodyBuilder: FormBody.Builder = FormBody.Builder();
                val size: Int = oldFromBody.size();
                for (i in 0..size) {
                    val name: String = oldFromBody.name(i);
                    val value: String = oldFromBody.value(i);
                    formBodyBuilder.add(name, value);
                }
                injectCommonParams(formBodyBuilder);
                newFormBody = formBodyBuilder.build();
            }
        }
        newRequestBuild
            .addHeader("Content-Type", "text/html; charset=UTF-8")
            .addHeader("Connection", "keep-alive")
            .addHeader("Accept", "*/*")
            .addHeader("Accept-Encoding", "Vary");
        if (newFormBody != null) newRequestBuild.post(newFormBody);
        val request: Request = newRequestBuild.build();
        return chain.proceed(request);
    }

    private fun injectCommonParams(formBodyBuilder: FormBody.Builder) {
        formBodyBuilder.add("platform", "Android")
    }
}
