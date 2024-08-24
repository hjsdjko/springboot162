package com.cl.entity.view;

import com.cl.entity.WanchengjihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 完成计划
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@TableName("wanchengjihua")
public class WanchengjihuaView  extends WanchengjihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WanchengjihuaView(){
	}
 
 	public WanchengjihuaView(WanchengjihuaEntity wanchengjihuaEntity){
 	try {
			BeanUtils.copyProperties(this, wanchengjihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
