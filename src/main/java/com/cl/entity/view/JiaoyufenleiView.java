package com.cl.entity.view;

import com.cl.entity.JiaoyufenleiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 教育分类
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-17 11:52:45
 */
@TableName("jiaoyufenlei")
public class JiaoyufenleiView  extends JiaoyufenleiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiaoyufenleiView(){
	}
 
 	public JiaoyufenleiView(JiaoyufenleiEntity jiaoyufenleiEntity){
 	try {
			BeanUtils.copyProperties(this, jiaoyufenleiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
