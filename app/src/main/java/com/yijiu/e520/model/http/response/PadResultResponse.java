package com.yijiu.e520.model.http.response;

/**
 * Api返回的统一格式
 * Created by Mr.yang on 2017/12/04
 */

public class PadResultResponse<T> {

    private String code;
    private String codeInfo;
    private T data;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
