package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaoyufenleiEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoyufenleiView;


/**
 * 教育分类
 *
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface JiaoyufenleiService extends IService<JiaoyufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaoyufenleiView> selectListView(Wrapper<JiaoyufenleiEntity> wrapper);
   	
   	JiaoyufenleiView selectView(@Param("ew") Wrapper<JiaoyufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaoyufenleiEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<JiaoyufenleiEntity> wrapper);

}

