package com.dao;

import com.entity.DiscussjianmeicaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjianmeicaoVO;
import com.entity.view.DiscussjianmeicaoView;


/**
 * 健美操评论表
 * 
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
public interface DiscussjianmeicaoDao extends BaseMapper<DiscussjianmeicaoEntity> {
	
	List<DiscussjianmeicaoVO> selectListVO(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
	
	DiscussjianmeicaoVO selectVO(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
	
	List<DiscussjianmeicaoView> selectListView(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);

	List<DiscussjianmeicaoView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
	
	DiscussjianmeicaoView selectView(@Param("ew") Wrapper<DiscussjianmeicaoEntity> wrapper);
	

}
