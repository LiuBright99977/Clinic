package cn.project.utils;

public class HttpRequest {
    private Integer code;
    private String message;
    private Object data;

    private HttpRequest(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static HttpRequest ok(Object data){
        return new HttpRequest(200,"获取数据成功",data);
    }
    public static HttpRequest ok(String message,Object data){
        return new HttpRequest(200,message,data);
    }
    public static HttpRequest error(String message){
        return new HttpRequest(500,"获取数据异常:"+message,null);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
