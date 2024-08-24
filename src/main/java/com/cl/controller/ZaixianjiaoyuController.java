package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.ZaixianjiaoyuEntity;
import com.cl.entity.view.ZaixianjiaoyuView;

import com.cl.service.ZaixianjiaoyuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;
import com.cl.service.StoreupService;
import com.cl.entity.StoreupEntity;

/**
 * 在线教育
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@RestController
@RequestMapping("/zaixianjiaoyu")
public class ZaixianjiaoyuController {
    @Autowired
    private ZaixianjiaoyuService zaixianjiaoyuService;

    @Autowired
    private StoreupService storeupService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianjiaoyuEntity zaixianjiaoyu,
		HttpServletRequest request){
        EntityWrapper<ZaixianjiaoyuEntity> ew = new EntityWrapper<ZaixianjiaoyuEntity>();

		PageUtils page = zaixianjiaoyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianjiaoyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianjiaoyuEntity zaixianjiaoyu, 
		HttpServletRequest request){
        EntityWrapper<ZaixianjiaoyuEntity> ew = new EntityWrapper<ZaixianjiaoyuEntity>();

		PageUtils page = zaixianjiaoyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianjiaoyu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianjiaoyuEntity zaixianjiaoyu){
       	EntityWrapper<ZaixianjiaoyuEntity> ew = new EntityWrapper<ZaixianjiaoyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianjiaoyu, "zaixianjiaoyu")); 
        return R.ok().put("data", zaixianjiaoyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianjiaoyuEntity zaixianjiaoyu){
        EntityWrapper< ZaixianjiaoyuEntity> ew = new EntityWrapper< ZaixianjiaoyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianjiaoyu, "zaixianjiaoyu")); 
		ZaixianjiaoyuView zaixianjiaoyuView =  zaixianjiaoyuService.selectView(ew);
		return R.ok("查询在线教育成功").put("data", zaixianjiaoyuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianjiaoyuEntity zaixianjiaoyu = zaixianjiaoyuService.selectById(id);
		zaixianjiaoyu = zaixianjiaoyuService.selectView(new EntityWrapper<ZaixianjiaoyuEntity>().eq("id", id));
        return R.ok().put("data", zaixianjiaoyu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianjiaoyuEntity zaixianjiaoyu = zaixianjiaoyuService.selectById(id);
		zaixianjiaoyu = zaixianjiaoyuService.selectView(new EntityWrapper<ZaixianjiaoyuEntity>().eq("id", id));
        return R.ok().put("data", zaixianjiaoyu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianjiaoyuEntity zaixianjiaoyu, HttpServletRequest request){
    	zaixianjiaoyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianjiaoyu);
        zaixianjiaoyuService.insert(zaixianjiaoyu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianjiaoyuEntity zaixianjiaoyu, HttpServletRequest request){
    	zaixianjiaoyu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(zaixianjiaoyu);
        zaixianjiaoyuService.insert(zaixianjiaoyu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaixianjiaoyuEntity zaixianjiaoyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianjiaoyu);
        zaixianjiaoyuService.updateById(zaixianjiaoyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianjiaoyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
