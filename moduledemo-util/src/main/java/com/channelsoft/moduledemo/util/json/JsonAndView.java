package com.channelsoft.moduledemo.util.json;
/*
 * $Id: JsonAndView.java 5075 2012-10-18 07:11:36Z you.zhou $ Copyright (c) 2012 Qunar.com. All Rights Reserved.
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author zhou Initial Created at 2012-12-10<p>
// -------------------------------------------------------
public class JsonAndView implements Serializable {

    private static final long serialVersionUID = -8690687070450659428L;

    /**
     * ִ���Ƿ�ɹ���true/false
     */
    private boolean ret = true;

    private int errcode = 0;

    private String errmsg = "";

    private int ver = 1;

    private Map<String, Object> data;

    /**
     * ����Ĭ��JsonAndView
     */
    public JsonAndView() {
    }

    /**
     * ʹ��ָ����ResultCode��message����
     * 
     * @param errCode
     * @param errmsg
     */
    public JsonAndView(int resultCode, String message) {
        if (resultCode != 0) {
            ret = false;
        }
        this.errcode = resultCode;
        this.errmsg = message;
    }

    /**
     * 
     * @param resultCode
     */
    public JsonAndView(int resultCode) {
        if (resultCode != 0) {
            ret = false;
        }
        this.errcode = resultCode;
    }

    public boolean isRet() {
        return ret;
    }

    public JsonAndView setRet(boolean ret) {
        this.ret = ret;
        return this;
    }

    public int getErrcode() {
        return errcode;
    }

    public JsonAndView setErrcode(int errcode) {
        this.errcode = errcode;
        return this;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public JsonAndView setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }

    /**
     * ������� �滻ԭ���������
     * 
     * @param data
     */
    public JsonAndView setData(Map<String, Object> data) {
        this.data = data;
        return this;
    }

    public Object getData() {
        return data;
    }

    /**
     * ������ Ҫ���ѳ��ж������Ϊ�ջ�������ΪMap
     * 
     * @param key
     * @param data
     */
    public JsonAndView addData(String key, Object data) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.put(key, data);
        return this;
    }

    /**
     * ����������� Ҫ�󵱴������ΪMapʱ�����ж������ΪMap����Ϊnull ���������ΪListʱ�������ж���ΪList����׷�ӣ������½�List����ԭ���ж���ʹ���List�е�ÿһ��Ԫ�ؼ��뵽List�� �������ʧ��
     * 
     * @param data
     */
    public JsonAndView addAllData(Map<String, Object> data) {
        if (this.data == null) {
            this.data = new HashMap<String, Object>();
        }
        this.data.putAll(data);
        return this;
    }

    public int getVer() {
        return ver;
    }

    public JsonAndView setVer(int ver) {
        this.ver = ver;
        return this;
    }

}
