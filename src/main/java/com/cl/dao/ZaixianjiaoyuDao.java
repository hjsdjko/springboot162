package com.cl.dao;

import com.cl.entity.ZaixianjiaoyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ZaixianjiaoyuView;


/**
 * 在线教育
 * 
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface ZaixianjiaoyuDao extends BaseMapper<ZaixianjiaoyuEntity> {
	
	List<ZaixianjiaoyuView> selectListView(@Param("ew") Wrapper<ZaixianjiaoyuEntity> wrapper);

	List<ZaixianjiaoyuView> selectListView(Pagination page,@Param("ew") Wrapper<ZaixianjiaoyuEntity> wrapper);
	
	ZaixianjiaoyuView selectView(@Param("ew") Wrapper<ZaixianjiaoyuEntity> wrapper);
	
	List<ZaixianjiaoyuView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ZaixianjiaoyuEntity> wrapper);

}
