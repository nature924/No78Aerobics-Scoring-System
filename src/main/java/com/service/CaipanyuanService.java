package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CaipanyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CaipanyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CaipanyuanView;


/**
 * 裁判员
 *
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
public interface CaipanyuanService extends IService<CaipanyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<CaipanyuanVO> selectListVO(Wrapper<CaipanyuanEntity> wrapper);
   	
   	CaipanyuanVO selectVO(@Param("ew") Wrapper<CaipanyuanEntity> wrapper);
   	
   	List<CaipanyuanView> selectListView(Wrapper<CaipanyuanEntity> wrapper);
   	
   	CaipanyuanView selectView(@Param("ew") Wrapper<CaipanyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<CaipanyuanEntity> wrapper);
   	

}

