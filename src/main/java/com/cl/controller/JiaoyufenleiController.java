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

import com.cl.entity.JiaoyufenleiEntity;
import com.cl.entity.view.JiaoyufenleiView;

import com.cl.service.JiaoyufenleiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 教育分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@RestController
@RequestMapping("/jiaoyufenlei")
public class JiaoyufenleiController {
    @Autowired
    private JiaoyufenleiService jiaoyufenleiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiaoyufenleiEntity jiaoyufenlei,
		HttpServletRequest request){
        EntityWrapper<JiaoyufenleiEntity> ew = new EntityWrapper<JiaoyufenleiEntity>();

		PageUtils page = jiaoyufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoyufenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiaoyufenleiEntity jiaoyufenlei, 
		HttpServletRequest request){
        EntityWrapper<JiaoyufenleiEntity> ew = new EntityWrapper<JiaoyufenleiEntity>();

		PageUtils page = jiaoyufenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiaoyufenlei), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiaoyufenleiEntity jiaoyufenlei){
       	EntityWrapper<JiaoyufenleiEntity> ew = new EntityWrapper<JiaoyufenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiaoyufenlei, "jiaoyufenlei")); 
        return R.ok().put("data", jiaoyufenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiaoyufenleiEntity jiaoyufenlei){
        EntityWrapper< JiaoyufenleiEntity> ew = new EntityWrapper< JiaoyufenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiaoyufenlei, "jiaoyufenlei")); 
		JiaoyufenleiView jiaoyufenleiView =  jiaoyufenleiService.selectView(ew);
		return R.ok("查询教育分类成功").put("data", jiaoyufenleiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiaoyufenleiEntity jiaoyufenlei = jiaoyufenleiService.selectById(id);
		jiaoyufenlei = jiaoyufenleiService.selectView(new EntityWrapper<JiaoyufenleiEntity>().eq("id", id));
        return R.ok().put("data", jiaoyufenlei);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiaoyufenleiEntity jiaoyufenlei = jiaoyufenleiService.selectById(id);
		jiaoyufenlei = jiaoyufenleiService.selectView(new EntityWrapper<JiaoyufenleiEntity>().eq("id", id));
        return R.ok().put("data", jiaoyufenlei);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoyufenleiEntity jiaoyufenlei, HttpServletRequest request){
    	jiaoyufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoyufenlei);
        jiaoyufenleiService.insert(jiaoyufenlei);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoyufenleiEntity jiaoyufenlei, HttpServletRequest request){
    	jiaoyufenlei.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiaoyufenlei);
        jiaoyufenleiService.insert(jiaoyufenlei);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiaoyufenleiEntity jiaoyufenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiaoyufenlei);
        jiaoyufenleiService.updateById(jiaoyufenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiaoyufenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
