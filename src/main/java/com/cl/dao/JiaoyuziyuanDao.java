package com.cl.dao;

import com.cl.entity.JiaoyuziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaoyuziyuanView;


/**
 * 教育资源
 * 
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface JiaoyuziyuanDao extends BaseMapper<JiaoyuziyuanEntity> {
	
	List<JiaoyuziyuanView> selectListView(@Param("ew") Wrapper<JiaoyuziyuanEntity> wrapper);

	List<JiaoyuziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JiaoyuziyuanEntity> wrapper);
	
	JiaoyuziyuanView selectView(@Param("ew") Wrapper<JiaoyuziyuanEntity> wrapper);
	
	List<JiaoyuziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<JiaoyuziyuanEntity> wrapper);

}
