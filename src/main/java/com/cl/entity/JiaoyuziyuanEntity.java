package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 教育资源
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@TableName("jiaoyuziyuan")
public class JiaoyuziyuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiaoyuziyuanEntity() {
		
	}
	
	public JiaoyuziyuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 教育标题
	 */
					
	private String jiaoyubiaoti;
	
	/**
	 * 教育分类
	 */
					
	private String jiaoyufenlei;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 教育资源
	 */
					
	private String jiaoyuziyuan;
	
	/**
	 * 教育详情
	 */
					
	private String jiaoyuxiangqing;
	
	/**
	 * 图片
	 */
					
	private String tupian;
	
	/**
	 * 收藏数量
	 */
					
	private Integer storeupnum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：教育标题
	 */
	public void setJiaoyubiaoti(String jiaoyubiaoti) {
		this.jiaoyubiaoti = jiaoyubiaoti;
	}
	/**
	 * 获取：教育标题
	 */
	public String getJiaoyubiaoti() {
		return jiaoyubiaoti;
	}
	/**
	 * 设置：教育分类
	 */
	public void setJiaoyufenlei(String jiaoyufenlei) {
		this.jiaoyufenlei = jiaoyufenlei;
	}
	/**
	 * 获取：教育分类
	 */
	public String getJiaoyufenlei() {
		return jiaoyufenlei;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：教育资源
	 */
	public void setJiaoyuziyuan(String jiaoyuziyuan) {
		this.jiaoyuziyuan = jiaoyuziyuan;
	}
	/**
	 * 获取：教育资源
	 */
	public String getJiaoyuziyuan() {
		return jiaoyuziyuan;
	}
	/**
	 * 设置：教育详情
	 */
	public void setJiaoyuxiangqing(String jiaoyuxiangqing) {
		this.jiaoyuxiangqing = jiaoyuxiangqing;
	}
	/**
	 * 获取：教育详情
	 */
	public String getJiaoyuxiangqing() {
		return jiaoyuxiangqing;
	}
	/**
	 * 设置：图片
	 */
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}

}
