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

import com.entity.PingfenEntity;
import com.entity.view.PingfenView;

import com.service.PingfenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 评分
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
@RestController
@RequestMapping("/pingfen")
public class PingfenController {
    @Autowired
    private PingfenService pingfenService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PingfenEntity pingfen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			pingfen.setYonghuming((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("caipanyuan")) {
			pingfen.setCaipanzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<PingfenEntity> ew = new EntityWrapper<PingfenEntity>();

		PageUtils page = pingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingfen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PingfenEntity pingfen, 
		HttpServletRequest request){
        EntityWrapper<PingfenEntity> ew = new EntityWrapper<PingfenEntity>();

		PageUtils page = pingfenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, pingfen), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PingfenEntity pingfen){
       	EntityWrapper<PingfenEntity> ew = new EntityWrapper<PingfenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( pingfen, "pingfen")); 
        return R.ok().put("data", pingfenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PingfenEntity pingfen){
        EntityWrapper< PingfenEntity> ew = new EntityWrapper< PingfenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( pingfen, "pingfen")); 
		PingfenView pingfenView =  pingfenService.selectView(ew);
		return R.ok("查询评分成功").put("data", pingfenView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PingfenEntity pingfen = pingfenService.selectById(id);
        return R.ok().put("data", pingfen);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PingfenEntity pingfen = pingfenService.selectById(id);
        return R.ok().put("data", pingfen);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PingfenEntity pingfen, HttpServletRequest request){
    	pingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingfen);
        pingfenService.insert(pingfen);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PingfenEntity pingfen, HttpServletRequest request){
    	pingfen.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(pingfen);
        pingfenService.insert(pingfen);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PingfenEntity pingfen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(pingfen);
        pingfenService.updateById(pingfen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        pingfenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	









}
