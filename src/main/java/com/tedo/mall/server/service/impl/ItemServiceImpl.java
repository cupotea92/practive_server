package com.tedo.mall.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.tedo.mall.server.mapper.CategoryMapper;
import com.tedo.mall.server.mapper.ItemMapper;
import com.tedo.mall.server.pojo.dto.ItemInsertDTO;
import com.tedo.mall.server.pojo.dto.ItemSelectDTO;
import com.tedo.mall.server.pojo.po.ItemPO;
import com.tedo.mall.server.pojo.vo.ItemVO;
import com.tedo.mall.server.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    //从spring容器中取访问数据曾的对象
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<ItemPO> selectByCategoryId(Integer categoryId){
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("category_id",categoryId);
        List list=itemMapper.selectList(queryWrapper);
        return list;
    }

    @Override
    public ItemPO selectById(Integer id){
    QueryWrapper queryWrapper=new QueryWrapper();
    queryWrapper.eq("id",id);
    ItemPO itemPo=itemMapper.selectOne(queryWrapper);
    return  itemPo;
    }

    @Override
    public boolean insert(ItemInsertDTO itemInsertDTO){
        ItemPO itemPO=new ItemPO();
        BeanUtils.copyProperties(itemInsertDTO,itemPO);
        int insertRow= itemMapper.insert(itemPO);
        if(insertRow==0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public List<ItemVO> select(ItemSelectDTO itemSelectDTO){
        String id=isNullOrEmpty(itemSelectDTO.getId());
        String categoryId=isNullOrEmpty(itemSelectDTO.getCategoryId());
        String name=isNullOrEmpty(itemSelectDTO.getName());
        String itemDesc=isNullOrEmpty(itemSelectDTO.getItemDesc());
        List<ItemVO> voList=itemMapper.select(id,categoryId,name,itemDesc);
        return voList;
    }
    private String isNullOrEmpty(Object obj){
        if(obj==null)
            return "";
        else if(obj.toString().isEmpty())
            return "";
        else return obj.toString();
    }
}
