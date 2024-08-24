package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WanchengjihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WanchengjihuaView;


/**
 * 完成计划
 *
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface WanchengjihuaService extends IService<WanchengjihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WanchengjihuaView> selectListView(Wrapper<WanchengjihuaEntity> wrapper);
   	
   	WanchengjihuaView selectView(@Param("ew") Wrapper<WanchengjihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WanchengjihuaEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<WanchengjihuaEntity> wrapper);

}

