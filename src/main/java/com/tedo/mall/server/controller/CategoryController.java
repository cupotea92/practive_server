package com.tedo.mall.server.controller;

import com.tedo.mall.server.pojo.ServerResult;
import com.tedo.mall.server.pojo.po.CategoryPO;
import com.tedo.mall.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired//自动注入1.写入了CategoryMapper接口，2.在ServerApplication中加入了MapperScan(com.tedo.mall.server.mapper)，生成了接口的实现类，生成了对象，放在spring容器中3.从soring容器中找CategoryMapper的对象
    CategoryService categoryService;

    @RequestMapping("/testException")
    public ServerResult testException(int n){
        int result=10/n;
        return new ServerResult(0,"成功",result);
    }

    @RequestMapping("/category/selectAll")
    public ServerResult selectAll(){
        List<CategoryPO> list=categoryService.selectAll();

        ServerResult serverResult=new ServerResult(0,"查询成功",list);
        return serverResult;
        //ServerResult serverResult=new ServerResult(0,"成功",list);
        //return serverResult;
    }
}
