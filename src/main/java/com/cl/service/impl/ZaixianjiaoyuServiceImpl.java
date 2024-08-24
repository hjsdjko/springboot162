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


import com.cl.dao.ZaixianjiaoyuDao;
import com.cl.entity.ZaixianjiaoyuEntity;
import com.cl.service.ZaixianjiaoyuService;
import com.cl.entity.view.ZaixianjiaoyuView;

@Service("zaixianjiaoyuService")
public class ZaixianjiaoyuServiceImpl extends ServiceImpl<ZaixianjiaoyuDao, ZaixianjiaoyuEntity> implements ZaixianjiaoyuService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<ZaixianjiaoyuEntity> wrapper) {
		Page<ZaixianjiaoyuView> page =new Query<ZaixianjiaoyuView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZaixianjiaoyuEntity> page = this.selectPage(
                new Query<ZaixianjiaoyuEntity>(params).getPage(),
                new EntityWrapper<ZaixianjiaoyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZaixianjiaoyuEntity> wrapper) {
		  Page<ZaixianjiaoyuView> page =new Query<ZaixianjiaoyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<ZaixianjiaoyuView> selectListView(Wrapper<ZaixianjiaoyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZaixianjiaoyuView selectView(Wrapper<ZaixianjiaoyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
