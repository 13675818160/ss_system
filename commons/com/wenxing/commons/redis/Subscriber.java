package com.wenxing.commons.redis;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.JedisPubSub;

import com.wenxing.commons.helper.JsonHelper;
import com.wenxing.commons.helper.LoggerHelper;

public class Subscriber extends JedisPubSub {
	private List<String> deviceIdList;
	
	private boolean update = false;

	@Override
	public void onMessage(String channel, String msg) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onPMessage(String arg0, String arg1, String arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onSubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onUnsubscribe(String arg0, int arg1) {
		// TODO Auto-generated method stub

	}


	public List<String> getDeviceIdList() {
		return deviceIdList;
	}

	public void setDeviceIdList(List<String> deviceIdList) {
		this.deviceIdList = deviceIdList;
	}

	

}
