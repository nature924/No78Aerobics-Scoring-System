package com.dao;

import com.entity.ShipinfenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShipinfenleiVO;
import com.entity.view.ShipinfenleiView;


/**
 * 视频分类
 * 
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
public interface ShipinfenleiDao extends BaseMapper<ShipinfenleiEntity> {
	
	List<ShipinfenleiVO> selectListVO(@Param("ew") Wrapper<ShipinfenleiEntity> wrapper);
	
	ShipinfenleiVO selectVO(@Param("ew") Wrapper<ShipinfenleiEntity> wrapper);
	
	List<ShipinfenleiView> selectListView(@Param("ew") Wrapper<ShipinfenleiEntity> wrapper);

	List<ShipinfenleiView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinfenleiEntity> wrapper);
	
	ShipinfenleiView selectView(@Param("ew") Wrapper<ShipinfenleiEntity> wrapper);
	

}
