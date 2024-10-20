package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JianmeicaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JianmeicaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JianmeicaoView;


/**
 * 健美操
 *
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
public interface JianmeicaoService extends IService<JianmeicaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JianmeicaoVO> selectListVO(Wrapper<JianmeicaoEntity> wrapper);
   	
   	JianmeicaoVO selectVO(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
   	
   	List<JianmeicaoView> selectListView(Wrapper<JianmeicaoEntity> wrapper);
   	
   	JianmeicaoView selectView(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JianmeicaoEntity> wrapper);
   	

}

