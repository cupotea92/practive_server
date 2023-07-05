package com.tedo.mall.server.controller;

import com.tedo.mall.server.pojo.ServerResult;
import com.tedo.mall.server.pojo.dto.ItemInsertDTO;
import com.tedo.mall.server.pojo.dto.ItemSelectDTO;
import com.tedo.mall.server.pojo.po.ItemPO;
import com.tedo.mall.server.pojo.vo.ItemVO;
import com.tedo.mall.server.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/item/selectByCategoryId")
    public ServerResult selectByCategoryId(Integer categoryId){
        List<ItemPO> list=itemService.selectByCategoryId((categoryId));
        return new ServerResult(0,"成功",list);
    }

    @RequestMapping("/item/selectById")
    public ItemPO selectById(Integer id){
        ItemPO itemPO=itemService.selectById(id);
        return itemPO;
    }

    @GetMapping("/item/insert")
    public ServerResult insert(ItemInsertDTO itemInsertDTO){
        if(itemService.insert(itemInsertDTO)){
            return new ServerResult(0,"成功",null);
        }else{
            return new ServerResult(100,"插入失败",null);
        }
    }
    @GetMapping("/item/select")
    public ServerResult select(ItemSelectDTO itemSelectDTO){
        List<ItemVO> voList=itemService.select(itemSelectDTO);
        return new ServerResult(0,"成功",voList);
    }
}
