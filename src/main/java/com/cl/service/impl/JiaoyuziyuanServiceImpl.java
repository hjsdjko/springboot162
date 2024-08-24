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


import com.cl.dao.JiaoyuziyuanDao;
import com.cl.entity.JiaoyuziyuanEntity;
import com.cl.service.JiaoyuziyuanService;
import com.cl.entity.view.JiaoyuziyuanView;

@Service("jiaoyuziyuanService")
public class JiaoyuziyuanServiceImpl extends ServiceImpl<JiaoyuziyuanDao, JiaoyuziyuanEntity> implements JiaoyuziyuanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<JiaoyuziyuanEntity> wrapper) {
		Page<JiaoyuziyuanView> page =new Query<JiaoyuziyuanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoyuziyuanEntity> page = this.selectPage(
                new Query<JiaoyuziyuanEntity>(params).getPage(),
                new EntityWrapper<JiaoyuziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoyuziyuanEntity> wrapper) {
		  Page<JiaoyuziyuanView> page =new Query<JiaoyuziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoyuziyuanView> selectListView(Wrapper<JiaoyuziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoyuziyuanView selectView(Wrapper<JiaoyuziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
