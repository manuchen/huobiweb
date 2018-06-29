package com.demo.service;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.model.AppraisedRates;
import com.demo.common.model.Blog;
import com.demo.utils.IdUtils;
import com.jfinal.plugin.activerecord.Page;

public class AppraisedRatesSercive {

	private static final AppraisedRates dao = new AppraisedRates().dao();
	
	
	public AppraisedRates getZuiXing() {
		return dao.findFirst("select * from appraised_rates order by createdAt desc");
	}
	
	public void add(AppraisedRates bean) {
		bean.save();
	}
	
	/**
	 * 插入数据通过josn
	 * @param bean
	 */
	public void addByTongJiJson(JSONObject json) {
		JSONObject appraisedRatesJson = JSONObject.parseObject(json.get("appraised_rates").toString());
//		System.out.println(appraisedRatesJson);
//		System.out.println(appraisedRatesJson.get("buy_rate"));
		AppraisedRates appraisedRates = new AppraisedRates();
		appraisedRates.setBuyRate(Double.valueOf(appraisedRatesJson.get("buy_rate").toString()));
		appraisedRates.setMaxRate(Double.valueOf(appraisedRatesJson.get("max_rate").toString()));
		appraisedRates.setMinRate(Double.valueOf(appraisedRatesJson.get("min_rate").toString()));
		appraisedRates.setRate24hAgo(Double.valueOf(appraisedRatesJson.get("rate_24h_ago").toString()));
		appraisedRates.setSellRate(Double.valueOf(appraisedRatesJson.get("sell_rate").toString()));
		appraisedRates.setId(IdUtils.getId());
		appraisedRates.setCreatedAt(new Date());
		appraisedRates.save();
	}
	
}
