package test.test;

import com.alibaba.fastjson.JSONObject;
import com.demo.common.model.AppraisedRates;
import com.demo.utils.HttpClientUtil;

public class Test1 {

	public static void main(String[] args) {
		String str = HttpClientUtil.doGet("http://18.216.158.43:8080/blog/test");
		JSONObject json = JSONObject.parseObject(str);
		System.out.println(json);
//		AppraisedRates appraisedRates = (AppraisedRates) json.get("appraised_rates");
//		System.out.println(appraisedRates);
		System.out.println(json.get("appraised_rates"));
		JSONObject appraisedRatesJson = JSONObject.parseObject(json.get("appraised_rates").toString());
		System.out.println(appraisedRatesJson);
//		System.out.println(appraisedRatesJson.get("buy_rate"));
		AppraisedRates appraisedRates = new AppraisedRates();
		appraisedRates.setBuyRate(Double.valueOf(appraisedRatesJson.get("buy_rate").toString()));
		appraisedRates.setMaxRate(Double.valueOf(appraisedRatesJson.get("max_rate").toString()));
		appraisedRates.setMinRate(Double.valueOf(appraisedRatesJson.get("min_rate").toString()));
		appraisedRates.setRate24hAgo(Double.valueOf(appraisedRatesJson.get("rate_24h_ago").toString()));
		appraisedRates.setSellRate(Double.valueOf(appraisedRatesJson.get("sell_rate").toString()));
		System.out.println(appraisedRates.toString());
	}
}
