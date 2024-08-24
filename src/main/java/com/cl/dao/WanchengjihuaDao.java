package com.cl.dao;

import com.cl.entity.WanchengjihuaEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WanchengjihuaView;


/**
 * 完成计划
 * 
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
public interface WanchengjihuaDao extends BaseMapper<WanchengjihuaEntity> {
	
	List<WanchengjihuaView> selectListView(@Param("ew") Wrapper<WanchengjihuaEntity> wrapper);

	List<WanchengjihuaView> selectListView(Pagination page,@Param("ew") Wrapper<WanchengjihuaEntity> wrapper);
	
	WanchengjihuaView selectView(@Param("ew") Wrapper<WanchengjihuaEntity> wrapper);
	
	List<WanchengjihuaView> selectGroupBy(Pagination page,@Param("ew") Wrapper<WanchengjihuaEntity> wrapper);

}
