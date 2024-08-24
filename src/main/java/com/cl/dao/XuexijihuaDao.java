package com.cl.dao;

import com.cl.entity.XuexijihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XuexijihuaView;


/**
 * 学习计划
 * 
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface XuexijihuaDao extends BaseMapper<XuexijihuaEntity> {
	
	List<XuexijihuaView> selectListView(@Param("ew") Wrapper<XuexijihuaEntity> wrapper);

	List<XuexijihuaView> selectListView(Pagination page,@Param("ew") Wrapper<XuexijihuaEntity> wrapper);
	
	XuexijihuaView selectView(@Param("ew") Wrapper<XuexijihuaEntity> wrapper);
	
	List<XuexijihuaView> selectGroupBy(Pagination page,@Param("ew") Wrapper<XuexijihuaEntity> wrapper);

}
