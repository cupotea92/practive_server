package com.tedo.mall.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tedo.mall.server.pojo.dto.ItemSelectDTO;
import com.tedo.mall.server.pojo.po.ItemPO;
import com.tedo.mall.server.pojo.vo.ItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper extends BaseMapper<ItemPO> {
    List<ItemVO> select(@Param("id") String id,@Param("categoryId") String categoryId,@Param("name") String name,@Param("itemDesc") String itemDesc);
}
