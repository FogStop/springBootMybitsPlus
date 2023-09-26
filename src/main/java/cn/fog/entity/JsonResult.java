package cn.fog.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult implements Serializable {

    // 响应业务状态
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static JsonResult build(Integer code, String msg, Object data) {
        return new JsonResult(code, msg, data);
    }
    public static JsonResult failure(Integer code, String msg) {
        return new JsonResult(code, msg, null);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public JsonResult() {

    }

    public static JsonResult build(Integer code, String msg) {
        return new JsonResult(code, msg, null);
    }

    public JsonResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Object data) {
        this.code = 200;
        this.msg = "OK";
        this.data = data;
    }



}