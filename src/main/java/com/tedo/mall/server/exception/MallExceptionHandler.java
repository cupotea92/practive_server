package com.tedo.mall.server.exception;

import com.tedo.mall.server.pojo.ServerResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MallExceptionHandler {

    @ExceptionHandler
    public ServerResult exceptionHandle(Throwable e){

        String message = e.getMessage();

        e.printStackTrace();

        ServerResult serverResult = new ServerResult(500, "服务器出错，到控制台查看错误详细信息", message);
        return  serverResult;

    }
}