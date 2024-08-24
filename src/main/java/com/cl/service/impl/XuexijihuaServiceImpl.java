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


import com.cl.dao.XuexijihuaDao;
import com.cl.entity.XuexijihuaEntity;
import com.cl.service.XuexijihuaService;
import com.cl.entity.view.XuexijihuaView;

@Service("xuexijihuaService")
public class XuexijihuaServiceImpl extends ServiceImpl<XuexijihuaDao, XuexijihuaEntity> implements XuexijihuaService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<XuexijihuaEntity> wrapper) {
		Page<XuexijihuaView> page =new Query<XuexijihuaView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XuexijihuaEntity> page = this.selectPage(
                new Query<XuexijihuaEntity>(params).getPage(),
                new EntityWrapper<XuexijihuaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XuexijihuaEntity> wrapper) {
		  Page<XuexijihuaView> page =new Query<XuexijihuaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XuexijihuaView> selectListView(Wrapper<XuexijihuaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XuexijihuaView selectView(Wrapper<XuexijihuaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
