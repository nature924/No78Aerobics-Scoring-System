package com.entity.view;

import com.entity.PingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 评分
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
@TableName("pingfen")
public class PingfenView  extends PingfenEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public PingfenView(){
	}
 
 	public PingfenView(PingfenEntity pingfenEntity){
 	try {
			BeanUtils.copyProperties(this, pingfenEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
