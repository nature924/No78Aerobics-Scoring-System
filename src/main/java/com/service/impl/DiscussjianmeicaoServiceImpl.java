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


import com.dao.DiscussjianmeicaoDao;
import com.entity.DiscussjianmeicaoEntity;
import com.service.DiscussjianmeicaoService;
import com.entity.vo.DiscussjianmeicaoVO;
import com.entity.view.DiscussjianmeicaoView;

@Service("discussjianmeicaoService")
public class DiscussjianmeicaoServiceImpl extends ServiceImpl<DiscussjianmeicaoDao, DiscussjianmeicaoEntity> implements DiscussjianmeicaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjianmeicaoEntity> page = this.selectPage(
                new Query<DiscussjianmeicaoEntity>(params).getPage(),
                new EntityWrapper<DiscussjianmeicaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjianmeicaoEntity> wrapper) {
		  Page<DiscussjianmeicaoView> page =new Query<DiscussjianmeicaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjianmeicaoVO> selectListVO(Wrapper<DiscussjianmeicaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjianmeicaoVO selectVO(Wrapper<DiscussjianmeicaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjianmeicaoView> selectListView(Wrapper<DiscussjianmeicaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjianmeicaoView selectView(Wrapper<DiscussjianmeicaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
