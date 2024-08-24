package com.cl.entity.view;

import com.cl.entity.XuexijihuaEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 学习计划
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@TableName("xuexijihua")
public class XuexijihuaView  extends XuexijihuaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XuexijihuaView(){
	}
 
 	public XuexijihuaView(XuexijihuaEntity xuexijihuaEntity){
 	try {
			BeanUtils.copyProperties(this, xuexijihuaEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
