package com.tedo.mall.server.service;

import com.tedo.mall.server.pojo.po.CategoryPO;

import java.util.List;

public interface CategoryService {
    public List<CategoryPO> selectAll();
}
