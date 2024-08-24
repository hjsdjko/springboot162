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

import com.cl.entity.WanchengjihuaEntity;
import com.cl.entity.view.WanchengjihuaView;

import com.cl.service.WanchengjihuaService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 完成计划
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@RestController
@RequestMapping("/wanchengjihua")
public class WanchengjihuaController {
    @Autowired
    private WanchengjihuaService wanchengjihuaService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WanchengjihuaEntity wanchengjihua,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wanchengjihua.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WanchengjihuaEntity> ew = new EntityWrapper<WanchengjihuaEntity>();

		PageUtils page = wanchengjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wanchengjihua), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WanchengjihuaEntity wanchengjihua, 
		HttpServletRequest request){
        EntityWrapper<WanchengjihuaEntity> ew = new EntityWrapper<WanchengjihuaEntity>();

		PageUtils page = wanchengjihuaService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wanchengjihua), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WanchengjihuaEntity wanchengjihua){
       	EntityWrapper<WanchengjihuaEntity> ew = new EntityWrapper<WanchengjihuaEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wanchengjihua, "wanchengjihua")); 
        return R.ok().put("data", wanchengjihuaService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WanchengjihuaEntity wanchengjihua){
        EntityWrapper< WanchengjihuaEntity> ew = new EntityWrapper< WanchengjihuaEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wanchengjihua, "wanchengjihua")); 
		WanchengjihuaView wanchengjihuaView =  wanchengjihuaService.selectView(ew);
		return R.ok("查询完成计划成功").put("data", wanchengjihuaView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WanchengjihuaEntity wanchengjihua = wanchengjihuaService.selectById(id);
		wanchengjihua = wanchengjihuaService.selectView(new EntityWrapper<WanchengjihuaEntity>().eq("id", id));
        return R.ok().put("data", wanchengjihua);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WanchengjihuaEntity wanchengjihua = wanchengjihuaService.selectById(id);
		wanchengjihua = wanchengjihuaService.selectView(new EntityWrapper<WanchengjihuaEntity>().eq("id", id));
        return R.ok().put("data", wanchengjihua);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WanchengjihuaEntity wanchengjihua, HttpServletRequest request){
    	wanchengjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wanchengjihua);
        wanchengjihuaService.insert(wanchengjihua);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WanchengjihuaEntity wanchengjihua, HttpServletRequest request){
    	wanchengjihua.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(wanchengjihua);
        wanchengjihuaService.insert(wanchengjihua);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WanchengjihuaEntity wanchengjihua, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wanchengjihua);
        wanchengjihuaService.updateById(wanchengjihua);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wanchengjihuaService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
