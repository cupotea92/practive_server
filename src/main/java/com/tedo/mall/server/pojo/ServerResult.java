package com.tedo.mall.server.pojo;
//在控制层返回给前端
public class ServerResult {
    int state;//状态码 0：成功 100：注册时用户名已存在 101：注册时字符非法
    String msg;//给状态码进行描述
    Object data;//可以保存list.单个对象，字符串

    public ServerResult(int state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
