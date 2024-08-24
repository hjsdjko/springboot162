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


import com.cl.dao.JiaoyufenleiDao;
import com.cl.entity.JiaoyufenleiEntity;
import com.cl.service.JiaoyufenleiService;
import com.cl.entity.view.JiaoyufenleiView;

@Service("jiaoyufenleiService")
public class JiaoyufenleiServiceImpl extends ServiceImpl<JiaoyufenleiDao, JiaoyufenleiEntity> implements JiaoyufenleiService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<JiaoyufenleiEntity> wrapper) {
		Page<JiaoyufenleiView> page =new Query<JiaoyufenleiView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaoyufenleiEntity> page = this.selectPage(
                new Query<JiaoyufenleiEntity>(params).getPage(),
                new EntityWrapper<JiaoyufenleiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaoyufenleiEntity> wrapper) {
		  Page<JiaoyufenleiView> page =new Query<JiaoyufenleiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaoyufenleiView> selectListView(Wrapper<JiaoyufenleiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaoyufenleiView selectView(Wrapper<JiaoyufenleiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
