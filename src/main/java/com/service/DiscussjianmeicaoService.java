package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjianmeicaoEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjianmeicaoVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjianmeicaoView;


/**
 * 健美操评论表
 *
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
public interface DiscussjianmeicaoService extends IService<DiscussjianmeicaoEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjianmeicaoVO> selectListVO(Wrapper<DiscussjianmeicaoEntity> wrapper);
   	
   	DiscussjianmeicaoVO selectVO(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
   	
   	List<DiscussjianmeicaoView> selectListView(Wrapper<DiscussjianmeicaoEntity> wrapper);
   	
   	DiscussjianmeicaoView selectView(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjianmeicaoEntity> wrapper);
   	

}

