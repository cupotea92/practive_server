package com.tedo.mall.server.service;

import com.tedo.mall.server.pojo.dto.ItemInsertDTO;
import com.tedo.mall.server.pojo.dto.ItemSelectDTO;
import com.tedo.mall.server.pojo.po.ItemPO;
import com.tedo.mall.server.pojo.vo.ItemVO;

import java.util.List;

public interface ItemService {
    public List<ItemPO> selectByCategoryId(Integer categoryId);
    public  ItemPO selectById(Integer id);
    public boolean insert(ItemInsertDTO itemInsertDTO);//添加商品
    public List<ItemVO> select(ItemSelectDTO itemSelectDTO);//查找商品
}
