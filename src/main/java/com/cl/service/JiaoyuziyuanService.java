package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoyuziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoyuziyuanView;


/**
 * 教育资源
 *
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface JiaoyuziyuanService extends IService<JiaoyuziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoyuziyuanView> selectListView(Wrapper<JiaoyuziyuanEntity> wrapper);
   	
   	JiaoyuziyuanView selectView(@Param("ew") Wrapper<JiaoyuziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoyuziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<JiaoyuziyuanEntity> wrapper);

}

