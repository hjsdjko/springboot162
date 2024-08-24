package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ZaixianjiaoyuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZaixianjiaoyuView;


/**
 * 在线教育
 *
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface ZaixianjiaoyuService extends IService<ZaixianjiaoyuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZaixianjiaoyuView> selectListView(Wrapper<ZaixianjiaoyuEntity> wrapper);
   	
   	ZaixianjiaoyuView selectView(@Param("ew") Wrapper<ZaixianjiaoyuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZaixianjiaoyuEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ZaixianjiaoyuEntity> wrapper);

}

