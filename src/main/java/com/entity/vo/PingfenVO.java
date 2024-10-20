package com.entity.vo;

import com.entity.PingfenEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 评分
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2023-04-29 14:34:33
 */
public class PingfenVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 视频标题
	 */
	
	private String shipinbiaoti;
		
	/**
	 * 视频分类
	 */
	
	private String shipinfenlei;
		
	/**
	 * 评价时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date pingjiashijian;
		
	/**
	 * 用户名
	 */
	
	private String yonghuming;
		
	/**
	 * 裁判账号
	 */
	
	private String caipanzhanghao;
		
	/**
	 * 裁判员
	 */
	
	private String caipanyuan;
		
	/**
	 * 评分
	 */
	
	private String pingfen;
		
	/**
	 * 评语
	 */
	
	private String pingyu;
				
	
	/**
	 * 设置：视频标题
	 */
	 
	public void setShipinbiaoti(String shipinbiaoti) {
		this.shipinbiaoti = shipinbiaoti;
	}
	
	/**
	 * 获取：视频标题
	 */
	public String getShipinbiaoti() {
		return shipinbiaoti;
	}
				
	
	/**
	 * 设置：视频分类
	 */
	 
	public void setShipinfenlei(String shipinfenlei) {
		this.shipinfenlei = shipinfenlei;
	}
	
	/**
	 * 获取：视频分类
	 */
	public String getShipinfenlei() {
		return shipinfenlei;
	}
				
	
	/**
	 * 设置：评价时间
	 */
	 
	public void setPingjiashijian(Date pingjiashijian) {
		this.pingjiashijian = pingjiashijian;
	}
	
	/**
	 * 获取：评价时间
	 */
	public Date getPingjiashijian() {
		return pingjiashijian;
	}
				
	
	/**
	 * 设置：用户名
	 */
	 
	public void setYonghuming(String yonghuming) {
		this.yonghuming = yonghuming;
	}
	
	/**
	 * 获取：用户名
	 */
	public String getYonghuming() {
		return yonghuming;
	}
				
	
	/**
	 * 设置：裁判账号
	 */
	 
	public void setCaipanzhanghao(String caipanzhanghao) {
		this.caipanzhanghao = caipanzhanghao;
	}
	
	/**
	 * 获取：裁判账号
	 */
	public String getCaipanzhanghao() {
		return caipanzhanghao;
	}
				
	
	/**
	 * 设置：裁判员
	 */
	 
	public void setCaipanyuan(String caipanyuan) {
		this.caipanyuan = caipanyuan;
	}
	
	/**
	 * 获取：裁判员
	 */
	public String getCaipanyuan() {
		return caipanyuan;
	}
				
	
	/**
	 * 设置：评分
	 */
	 
	public void setPingfen(String pingfen) {
		this.pingfen = pingfen;
	}
	
	/**
	 * 获取：评分
	 */
	public String getPingfen() {
		return pingfen;
	}
				
	
	/**
	 * 设置：评语
	 */
	 
	public void setPingyu(String pingyu) {
		this.pingyu = pingyu;
	}
	
	/**
	 * 获取：评语
	 */
	public String getPingyu() {
		return pingyu;
	}
			
}
