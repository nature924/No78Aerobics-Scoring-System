package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingfenEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingfenVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingfenView;


/**
 * 评分
 *
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
public interface PingfenService extends IService<PingfenEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingfenVO> selectListVO(Wrapper<PingfenEntity> wrapper);
   	
   	PingfenVO selectVO(@Param("ew") Wrapper<PingfenEntity> wrapper);
   	
   	List<PingfenView> selectListView(Wrapper<PingfenEntity> wrapper);
   	
   	PingfenView selectView(@Param("ew") Wrapper<PingfenEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingfenEntity> wrapper);
   	

}

