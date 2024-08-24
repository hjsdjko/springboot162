package com.cl.dao;

import com.cl.entity.JiaoyufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoyufenleiView;


/**
 * 教育分类
 * 
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface JiaoyufenleiDao extends BaseMapper<JiaoyufenleiEntity> {
	
	List<JiaoyufenleiView> selectListView(@Param("ew") Wrapper<JiaoyufenleiEntity> wrapper);

	List<JiaoyufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoyufenleiEntity> wrapper);
	
	JiaoyufenleiView selectView(@Param("ew") Wrapper<JiaoyufenleiEntity> wrapper);
	
	List<JiaoyufenleiView> selectGroupBy(Pagination page,@Param("ew") Wrapper<JiaoyufenleiEntity> wrapper);

}
