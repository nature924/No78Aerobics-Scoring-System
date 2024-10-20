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

import com.entity.JianmeicaoEntity;
import com.entity.view.JianmeicaoView;

import com.service.JianmeicaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 健美操
 * 后端接口
 * @author 
 * @email 
 * @date 2023-04-29 14:34:32
 */
@RestController
@RequestMapping("/jianmeicao")
public class JianmeicaoController {
    @Autowired
    private JianmeicaoService jianmeicaoService;

    @Autowired
    private StoreupService storeupService;

    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JianmeicaoEntity jianmeicao,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jianmeicao.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JianmeicaoEntity> ew = new EntityWrapper<JianmeicaoEntity>();

		PageUtils page = jianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianmeicao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JianmeicaoEntity jianmeicao, 
		HttpServletRequest request){
        EntityWrapper<JianmeicaoEntity> ew = new EntityWrapper<JianmeicaoEntity>();

		PageUtils page = jianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianmeicao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JianmeicaoEntity jianmeicao){
       	EntityWrapper<JianmeicaoEntity> ew = new EntityWrapper<JianmeicaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jianmeicao, "jianmeicao")); 
        return R.ok().put("data", jianmeicaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JianmeicaoEntity jianmeicao){
        EntityWrapper< JianmeicaoEntity> ew = new EntityWrapper< JianmeicaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jianmeicao, "jianmeicao")); 
		JianmeicaoView jianmeicaoView =  jianmeicaoService.selectView(ew);
		return R.ok("查询健美操成功").put("data", jianmeicaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JianmeicaoEntity jianmeicao = jianmeicaoService.selectById(id);
		jianmeicao.setClicknum(jianmeicao.getClicknum()+1);
		jianmeicao.setClicktime(new Date());
		jianmeicaoService.updateById(jianmeicao);
        return R.ok().put("data", jianmeicao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JianmeicaoEntity jianmeicao = jianmeicaoService.selectById(id);
		jianmeicao.setClicknum(jianmeicao.getClicknum()+1);
		jianmeicao.setClicktime(new Date());
		jianmeicaoService.updateById(jianmeicao);
        return R.ok().put("data", jianmeicao);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JianmeicaoEntity jianmeicao = jianmeicaoService.selectById(id);
        if(type.equals("1")) {
        	jianmeicao.setThumbsupnum(jianmeicao.getThumbsupnum()+1);
        } else {
        	jianmeicao.setCrazilynum(jianmeicao.getCrazilynum()+1);
        }
        jianmeicaoService.updateById(jianmeicao);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JianmeicaoEntity jianmeicao, HttpServletRequest request){
    	jianmeicao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianmeicao);
        jianmeicaoService.insert(jianmeicao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JianmeicaoEntity jianmeicao, HttpServletRequest request){
    	jianmeicao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jianmeicao);
        jianmeicaoService.insert(jianmeicao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JianmeicaoEntity jianmeicao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jianmeicao);
        jianmeicaoService.updateById(jianmeicao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jianmeicaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,JianmeicaoEntity jianmeicao, HttpServletRequest request,String pre){
        EntityWrapper<JianmeicaoEntity> ew = new EntityWrapper<JianmeicaoEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicknum");
        params.put("order", "desc");
		PageUtils page = jianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianmeicao), params), params));
        return R.ok().put("data", page);
    }


    /**
     * 协同算法（按收藏推荐）
     */
    @RequestMapping("/autoSort2")
    public R autoSort2(@RequestParam Map<String, Object> params,JianmeicaoEntity jianmeicao, HttpServletRequest request){
        String userId = request.getSession().getAttribute("userId").toString();
        String inteltypeColumn = "shipinfenlei";
        List<StoreupEntity> storeups = storeupService.selectList(new EntityWrapper<StoreupEntity>().eq("type", 1).eq("userid", userId).eq("tablename", "jianmeicao").orderBy("addtime", false));
        List<String> inteltypes = new ArrayList<String>();
        Integer limit = params.get("limit")==null?10:Integer.parseInt(params.get("limit").toString());
        List<JianmeicaoEntity> jianmeicaoList = new ArrayList<JianmeicaoEntity>();
        //去重
        if(storeups!=null && storeups.size()>0) {
            for(StoreupEntity s : storeups) {
                jianmeicaoList.addAll(jianmeicaoService.selectList(new EntityWrapper<JianmeicaoEntity>().eq(inteltypeColumn, s.getInteltype())));
            }
        }
        EntityWrapper<JianmeicaoEntity> ew = new EntityWrapper<JianmeicaoEntity>();
        params.put("sort", "id");
        params.put("order", "desc");
        PageUtils page = jianmeicaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jianmeicao), params), params));
        List<JianmeicaoEntity> pageList = (List<JianmeicaoEntity>)page.getList();
        if(jianmeicaoList.size()<limit) {
            int toAddNum = (limit-jianmeicaoList.size())<=pageList.size()?(limit-jianmeicaoList.size()):pageList.size();
            for(JianmeicaoEntity o1 : pageList) {
                boolean addFlag = true;
                for(JianmeicaoEntity o2 : jianmeicaoList) {
                    if(o1.getId().intValue()==o2.getId().intValue()) {
                        addFlag = false;
                        break;
                    }
                }
                if(addFlag) {
                    jianmeicaoList.add(o1);
                    if(--toAddNum==0) break;
                }
            }
        } else if(jianmeicaoList.size()>limit) {
            jianmeicaoList = jianmeicaoList.subList(0, limit);
        }
        page.setList(jianmeicaoList);
        return R.ok().put("data", page);
    }







}
