package com.dao;

import com.entity.PingfenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingfenVO;
import com.entity.view.PingfenView;


/**
 * 评分
 * 
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
public interface PingfenDao extends BaseMapper<PingfenEntity> {
	
	List<PingfenVO> selectListVO(@Param("ew") Wrapper<PingfenEntity> wrapper);
	
	PingfenVO selectVO(@Param("ew") Wrapper<PingfenEntity> wrapper);
	
	List<PingfenView> selectListView(@Param("ew") Wrapper<PingfenEntity> wrapper);

	List<PingfenView> selectListView(Pagination page,@Param("ew") Wrapper<PingfenEntity> wrapper);
	
	PingfenView selectView(@Param("ew") Wrapper<PingfenEntity> wrapper);
	

}
