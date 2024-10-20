package com.dao;

import com.entity.JianmeicaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JianmeicaoVO;
import com.entity.view.JianmeicaoView;


/**
 * 健美操
 * 
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
public interface JianmeicaoDao extends BaseMapper<JianmeicaoEntity> {
	
	List<JianmeicaoVO> selectListVO(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
	
	JianmeicaoVO selectVO(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
	
	List<JianmeicaoView> selectListView(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);

	List<JianmeicaoView> selectListView(Pagination page,@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
	
	JianmeicaoView selectView(@Param("ew") Wrapper<JianmeicaoEntity> wrapper);
	

}
