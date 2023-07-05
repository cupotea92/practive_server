package com.tedo.mall.server.service;

import com.tedo.mall.server.pojo.dto.UserDTO;
import com.tedo.mall.server.pojo.dto.UserNamePasswordDTO;
import com.tedo.mall.server.pojo.vo.UserVO;

public interface UserService {

    //登录
    public Integer login(UserDTO userDto);
    public UserVO getInfo(Integer userId);
    public Integer userRegister(UserDTO userDTO);
    public boolean changePassword(UserNamePasswordDTO userNamePasswordDTO);
    public boolean deleteUser(UserDTO userDTO);
}
