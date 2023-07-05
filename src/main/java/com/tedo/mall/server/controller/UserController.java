package com.tedo.mall.server.controller;

import com.tedo.mall.server.pojo.ServerResult;
import com.tedo.mall.server.pojo.dto.UserDTO;
import com.tedo.mall.server.pojo.dto.UserNamePasswordDTO;
import com.tedo.mall.server.pojo.vo.UserVO;
import com.tedo.mall.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/user/login")
    public ServerResult login(UserDTO userDTO){
        Integer userId= userService.login(userDTO);
        if(userId>=1){
            return new ServerResult(0,"成功",userId);
        }else{
            return new ServerResult(301,"登录失败",null);
        }
    }

    @RequestMapping("/user/getInfo")
    public ServerResult getInfo(Integer userId){
        UserVO userVO=userService.getInfo(userId);
        return new ServerResult(0,"成功",userVO);
    }

    @RequestMapping("/user/register")
    public ServerResult register(UserDTO userDTO){
        Integer registerId=userService.userRegister(userDTO);
        if(registerId>=1){
            return new ServerResult(0,"成功",registerId);
        }else{
            return new ServerResult(500,"注册失败",null);
        }
    }

    @RequestMapping("/user/changePassword")
    public ServerResult changePassword(UserNamePasswordDTO userNamePasswordDTO){
        boolean isSuccess=userService.changePassword(userNamePasswordDTO);
        if(isSuccess){
            return new ServerResult(0,"修改密码成功",null);
        }else{
            return new ServerResult(103,"修改密码失败",null);
        }
    }

    @RequestMapping("/user/deleteUser")
    public ServerResult deleteUser(UserDTO userDTO){
        if(userService.deleteUser(userDTO)){
            return new ServerResult(0,"成功",null);
        }else{
            return new ServerResult(500,"删除失败",null);
        }
    }
}
