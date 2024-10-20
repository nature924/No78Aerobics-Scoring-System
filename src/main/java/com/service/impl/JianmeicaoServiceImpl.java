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


import com.dao.JianmeicaoDao;
import com.entity.JianmeicaoEntity;
import com.service.JianmeicaoService;
import com.entity.vo.JianmeicaoVO;
import com.entity.view.JianmeicaoView;

@Service("jianmeicaoService")
public class JianmeicaoServiceImpl extends ServiceImpl<JianmeicaoDao, JianmeicaoEntity> implements JianmeicaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JianmeicaoEntity> page = this.selectPage(
                new Query<JianmeicaoEntity>(params).getPage(),
                new EntityWrapper<JianmeicaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JianmeicaoEntity> wrapper) {
		  Page<JianmeicaoView> page =new Query<JianmeicaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JianmeicaoVO> selectListVO(Wrapper<JianmeicaoEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JianmeicaoVO selectVO(Wrapper<JianmeicaoEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JianmeicaoView> selectListView(Wrapper<JianmeicaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JianmeicaoView selectView(Wrapper<JianmeicaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
