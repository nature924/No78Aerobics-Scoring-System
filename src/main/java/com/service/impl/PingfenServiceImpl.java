package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PingfenDao;
import com.entity.PingfenEntity;
import com.service.PingfenService;
import com.entity.vo.PingfenVO;
import com.entity.view.PingfenView;

@Service("pingfenService")
public class PingfenServiceImpl extends ServiceImpl<PingfenDao, PingfenEntity> implements PingfenService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PingfenEntity> page = this.selectPage(
                new Query<PingfenEntity>(params).getPage(),
                new EntityWrapper<PingfenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PingfenEntity> wrapper) {
		  Page<PingfenView> page =new Query<PingfenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<PingfenVO> selectListVO(Wrapper<PingfenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PingfenVO selectVO(Wrapper<PingfenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PingfenView> selectListView(Wrapper<PingfenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PingfenView selectView(Wrapper<PingfenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
