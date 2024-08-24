package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XuexijihuaEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexijihuaView;


/**
 * 学习计划
 *
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface XuexijihuaService extends IService<XuexijihuaEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XuexijihuaView> selectListView(Wrapper<XuexijihuaEntity> wrapper);
   	
   	XuexijihuaView selectView(@Param("ew") Wrapper<XuexijihuaEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XuexijihuaEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<XuexijihuaEntity> wrapper);

}

