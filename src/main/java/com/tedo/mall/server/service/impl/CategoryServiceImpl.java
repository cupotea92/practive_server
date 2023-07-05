package com.tedo.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedo.mall.server.mapper.CategoryMapper;
import com.tedo.mall.server.pojo.po.CategoryPO;
import com.tedo.mall.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<CategoryPO> selectAll(){
        QueryWrapper queryWrapper=null;
        List  list=categoryMapper.selectList(queryWrapper);
        return list;
    }
}
