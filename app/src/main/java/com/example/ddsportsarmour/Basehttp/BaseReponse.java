package com.example.ddsportsarmour.Basehttp;

public class BaseReponse<T> {
    private static int SUCCESS_CODE=200;//成功的code
    private int code;                   //响应码
    private String message;             //提示信息
    private T results;                  //返回的具体数据

    public boolean isSuccess(){
        return getCode()==SUCCESS_CODE;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResults() {
        return results;
    }

    public void setResults(T results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "BaseReponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", results=" + results +
                '}';
    }
}
