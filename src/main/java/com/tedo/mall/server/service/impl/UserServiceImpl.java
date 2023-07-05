package com.tedo.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedo.mall.server.mapper.UserMapper;
import com.tedo.mall.server.pojo.dto.UserDTO;
import com.tedo.mall.server.pojo.dto.UserNamePasswordDTO;
import com.tedo.mall.server.pojo.po.UserPO;
import com.tedo.mall.server.pojo.vo.UserVO;
import com.tedo.mall.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public Integer login(UserDTO userDto){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name",userDto.getName());
        queryWrapper.eq("password",userDto.getPassword());

        UserPO userPo=userMapper.selectOne(queryWrapper);
        if(userPo!=null){
            return userPo.getId();
        }
        return -1;
    }

    @Override
    public UserVO getInfo(Integer userId){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("id",userId);
        UserPO userPO=userMapper.selectOne((queryWrapper));
        if(userPO==null) {
            throw new RuntimeException("用户不存在");
        }
            else{
                UserVO userVO=new UserVO();
                userVO.setId((userId));
                userVO.setName(userPO.getName());
                userVO.setLevel(10);
                return userVO;
            }
    }

    @Override
    public Integer userRegister(UserDTO userDTO){
        //检测是否重名
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        UserPO userPO=userMapper.selectOne(queryWrapper);
        if(userPO!=null){
            throw new RuntimeException("用户名已被注册");
        }else{
            UserPO insertUserPO=new UserPO();
            insertUserPO.setName(userDTO.getName());
            insertUserPO.setPassword(userDTO.getPassword());
            int insertRow=userMapper.insert(insertUserPO);
            if(insertRow==0){
                throw new RuntimeException("保存用户失败");
            }else{
                QueryWrapper insertQueryWrapper=new QueryWrapper();
                insertQueryWrapper.eq("name",userDTO.getName());
                insertQueryWrapper.eq("password",userDTO.getPassword());
                UserPO selectUserPO=userMapper.selectOne(insertQueryWrapper);
                if(selectUserPO!=null){
                    return selectUserPO.getId();
                }else{
                    throw new RuntimeException("查询保存用户失败");
                }
            }
        }
    }

    @Override
    public boolean changePassword(UserNamePasswordDTO userNamePasswordDTO){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name",userNamePasswordDTO.getName());
        queryWrapper.eq("password",userNamePasswordDTO.getOldPassword());

        UserPO userPO=new UserPO();
        userPO.setPassword(userNamePasswordDTO.getNewPassword());

        int updateRow=userMapper.update(userPO,queryWrapper);
        return updateRow>=1 ? true:false;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("name",userDTO.getName());
        queryWrapper.eq("password",userDTO.getPassword());

        UserPO userPO=userMapper.selectOne(queryWrapper);
        if(userPO==null){
            throw new RuntimeException("找不到对应的用户或密码错误");
        }else{
            int deleteRow=userMapper.delete(queryWrapper);
            if(deleteRow==0){
                throw new RuntimeException("删除用户失败");
            }else{
                return true;
            }
        }
    }
}
