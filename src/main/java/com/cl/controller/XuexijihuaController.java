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

import com.cl.entity.XuexijihuaEntity;
import com.cl.entity.view.XuexijihuaView;

import com.cl.service.XuexijihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 学习计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@RestController
@RequestMapping("/xuexijihua")
public class XuexijihuaController {
    @Autowired
    private XuexijihuaService xuexijihuaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XuexijihuaEntity xuexijihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xuexijihua.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XuexijihuaEntity> ew = new EntityWrapper<XuexijihuaEntity>();

		PageUtils page = xuexijihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexijihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XuexijihuaEntity xuexijihua, 
		HttpServletRequest request){
        EntityWrapper<XuexijihuaEntity> ew = new EntityWrapper<XuexijihuaEntity>();

		PageUtils page = xuexijihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xuexijihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XuexijihuaEntity xuexijihua){
       	EntityWrapper<XuexijihuaEntity> ew = new EntityWrapper<XuexijihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xuexijihua, "xuexijihua")); 
        return R.ok().put("data", xuexijihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XuexijihuaEntity xuexijihua){
        EntityWrapper< XuexijihuaEntity> ew = new EntityWrapper< XuexijihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xuexijihua, "xuexijihua")); 
		XuexijihuaView xuexijihuaView =  xuexijihuaService.selectView(ew);
		return R.ok("查询学习计划成功").put("data", xuexijihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XuexijihuaEntity xuexijihua = xuexijihuaService.selectById(id);
		xuexijihua = xuexijihuaService.selectView(new EntityWrapper<XuexijihuaEntity>().eq("id", id));
        return R.ok().put("data", xuexijihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XuexijihuaEntity xuexijihua = xuexijihuaService.selectById(id);
		xuexijihua = xuexijihuaService.selectView(new EntityWrapper<XuexijihuaEntity>().eq("id", id));
        return R.ok().put("data", xuexijihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XuexijihuaEntity xuexijihua, HttpServletRequest request){
    	xuexijihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexijihua);
        xuexijihuaService.insert(xuexijihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XuexijihuaEntity xuexijihua, HttpServletRequest request){
    	xuexijihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xuexijihua);
        xuexijihuaService.insert(xuexijihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XuexijihuaEntity xuexijihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xuexijihua);
        xuexijihuaService.updateById(xuexijihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xuexijihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
