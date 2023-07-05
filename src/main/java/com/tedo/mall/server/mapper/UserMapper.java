package com.tedo.mall.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedo.mall.server.pojo.po.UserPO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserPO> {

}
