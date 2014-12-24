/**
 * $Id: JsonpView.java 3972 2012-09-11 02:40:46Z you.zhou $ Copyright (c) 2012 Qunar.com. All Rights Reserved.
 */
package com.channelsoft.moduledemo.util.json;

import com.channelsoft.moduledemo.util.adapter.JsonAndViewMethodReturnValueHandler;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JsonpView extends MappingJacksonJsonView implements InitializingBean {

    private final static String DEFAULT_CALLBACK_PARAM = "callback";

    private String callbackParam = DEFAULT_CALLBACK_PARAM;

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if ("GET".equals(request.getMethod().toUpperCase())) {
            String callback = request.getParameter(callbackParam);
            if (StringUtils.isBlank(callback)) {
                super.render(model, request, response);
            } else {
                response.getOutputStream().print(callback + "(");
                super.render(model, request, response);
                response.getOutputStream().print(");");
            }
        } else {
            super.render(model, request, response);
        }
    }

    public String getCallbackParam() {
        return callbackParam;
    }

    public void setCallbackParam(String callbackParam) {
        this.callbackParam = callbackParam;
    }

    public void afterPropertiesSet() throws Exception {
        this.setModelKey(JsonAndViewMethodReturnValueHandler.JAV_MODEL_KEY);
    }

}
