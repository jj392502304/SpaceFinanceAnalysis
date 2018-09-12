package com.sfa.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.sfa.configurer.AliyunMessageUtil;
@RestController
public class SendMsgController {
	@GetMapping("/sendMsg")
	public String sendMsg(@RequestParam String phoneNumber) throws ClientException {
	    String randomNum = createRandomNum(6);
	    String jsonContent = "{\"code\":\"" + randomNum + "\"}";

	    Map<String, String> paramMap = new HashMap<>();
	    paramMap.put("phoneNumber", phoneNumber);
	    paramMap.put("msgSign", "交通综合信息管理云平台");
	    paramMap.put("templateCode", "SMS_144451382");
	    paramMap.put("jsonContent", jsonContent);
	    SendSmsResponse sendSmsResponse = AliyunMessageUtil.sendSms(paramMap);
	    
		return sendSmsResponse.getCode();
	}

	/**
	 * 生成随机数
	 * @param num 位数
	 * @return
	 */
	public static String createRandomNum(int num){
	    String randomNumStr = "";
	    for(int i = 0; i < num;i ++){
	        int randomNum = (int)(Math.random() * 10);
	        randomNumStr += randomNum;
	    }
	    return randomNumStr;
	}
}
