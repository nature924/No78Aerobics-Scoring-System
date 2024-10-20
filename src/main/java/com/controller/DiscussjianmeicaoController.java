package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscussjianmeicaoEntity;
import com.entity.view.DiscussjianmeicaoView;

import com.service.DiscussjianmeicaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 健美操评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
@RestController
@RequestMapping("/discussjianmeicao")
public class DiscussjianmeicaoController {
    @Autowired
    private DiscussjianmeicaoService discussjianmeicaoService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjianmeicaoEntity discussjianmeicao,
		HttpServletRequest request){
        EntityWrapper<DiscussjianmeicaoEntity> ew = new EntityWrapper<DiscussjianmeicaoEntity>();

		PageUtils page = discussjianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjianmeicao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjianmeicaoEntity discussjianmeicao, 
		HttpServletRequest request){
        EntityWrapper<DiscussjianmeicaoEntity> ew = new EntityWrapper<DiscussjianmeicaoEntity>();

		PageUtils page = discussjianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjianmeicao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjianmeicaoEntity discussjianmeicao){
       	EntityWrapper<DiscussjianmeicaoEntity> ew = new EntityWrapper<DiscussjianmeicaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjianmeicao, "discussjianmeicao")); 
        return R.ok().put("data", discussjianmeicaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjianmeicaoEntity discussjianmeicao){
        EntityWrapper< DiscussjianmeicaoEntity> ew = new EntityWrapper< DiscussjianmeicaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjianmeicao, "discussjianmeicao")); 
		DiscussjianmeicaoView discussjianmeicaoView =  discussjianmeicaoService.selectView(ew);
		return R.ok("查询健美操评论表成功").put("data", discussjianmeicaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjianmeicaoEntity discussjianmeicao = discussjianmeicaoService.selectById(id);
        return R.ok().put("data", discussjianmeicao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjianmeicaoEntity discussjianmeicao = discussjianmeicaoService.selectById(id);
        return R.ok().put("data", discussjianmeicao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjianmeicaoEntity discussjianmeicao, HttpServletRequest request){
    	discussjianmeicao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjianmeicao);
        discussjianmeicaoService.insert(discussjianmeicao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjianmeicaoEntity discussjianmeicao, HttpServletRequest request){
    	discussjianmeicao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjianmeicao);
        discussjianmeicaoService.insert(discussjianmeicao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiscussjianmeicaoEntity discussjianmeicao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjianmeicao);
        discussjianmeicaoService.updateById(discussjianmeicao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjianmeicaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
