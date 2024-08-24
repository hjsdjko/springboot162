package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.WanchengjihuaDao;
import com.cl.entity.WanchengjihuaEntity;
import com.cl.service.WanchengjihuaService;
import com.cl.entity.view.WanchengjihuaView;

@Service("wanchengjihuaService")
public class WanchengjihuaServiceImpl extends ServiceImpl<WanchengjihuaDao, WanchengjihuaEntity> implements WanchengjihuaService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<WanchengjihuaEntity> wrapper) {
		Page<WanchengjihuaView> page =new Query<WanchengjihuaView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WanchengjihuaEntity> page = this.selectPage(
                new Query<WanchengjihuaEntity>(params).getPage(),
                new EntityWrapper<WanchengjihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WanchengjihuaEntity> wrapper) {
		  Page<WanchengjihuaView> page =new Query<WanchengjihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<WanchengjihuaView> selectListView(Wrapper<WanchengjihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WanchengjihuaView selectView(Wrapper<WanchengjihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
