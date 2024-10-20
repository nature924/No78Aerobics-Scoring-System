package com.entity.view;

import com.entity.JianmeicaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 健美操
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
@TableName("jianmeicao")
public class JianmeicaoView  extends JianmeicaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JianmeicaoView(){
	}
 
 	public JianmeicaoView(JianmeicaoEntity jianmeicaoEntity){
 	try {
			BeanUtils.copyProperties(this, jianmeicaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
