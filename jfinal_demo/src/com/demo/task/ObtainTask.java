package com.demo.task;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.ITask;
import com.demo.service.AppraisedRatesSercive;
import com.demo.utils.HttpClientUtil;

public class ObtainTask implements ITask {

	private AppraisedRatesSercive appraisedRatesSercive = new AppraisedRatesSercive();
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		String str = HttpClientUtil.doGet("https://gate.io/json_svr/query_push/?u=13&c=547487&type=push_main_rates&symbol=USDT_CNY");
//		String str = HttpClientUtil.doGet("http://18.216.158.43:8080/blog/test");
		JSONObject json = JSONObject.parseObject(str);
		appraisedRatesSercive.addByTongJiJson(json);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
