package com.wenxing.commons.redis;

import com.wenxing.commons.helper.FileHelper;
import com.wenxing.commons.helper.JsonHelper;
import com.wenxing.commons.helper.LoggerHelper;
import com.wenxing.commons.helper.StringHelper;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
	private static JedisPool pool = null;
	private static Subscriber jedisPubSub = new Subscriber();

	public static JedisPool getPool() throws IOException {
		if (pool == null) {
			JedisPoolConfig config = new JedisPoolConfig();

			String classpath = Thread.currentThread().getContextClassLoader()
					.getResource("").toString();
			classpath = StringHelper.delStartChar(classpath, 5);
			classpath = classpath.replace("/", "//");

			Map<String, String> map = FileHelper.getPropertiesMap(classpath
					+ "redis.properties");

			// 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
			// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
			config.setMaxActive(Integer.valueOf(map.get("redis.maxActive")));
			// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
			config.setMaxIdle(Integer.valueOf(map.get("redis.maxIdle")));
			// 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
			config.setMaxWait(Integer.valueOf(map.get("redis.maxWait")));
			// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
			config.setTestOnBorrow(true);
			pool = new JedisPool(map.get("redis.ip"));
		}
		return pool;
	}

	public static void returnResource(JedisPool pool, Jedis redis) {
		if (redis != null) {
			pool.returnResource(redis);
		}
	}

	public static String get(String key) {
		String value = null;

		JedisPool pool = null;
		Jedis jedis = null;
		try {
			pool = getPool();
			jedis = (Jedis) pool.getResource();
			value = jedis.get(key);
		} catch (Exception e) {
			pool.returnBrokenResource(jedis);
			e.printStackTrace();
		} finally {
			jedis.disconnect();

			returnResource(pool, jedis);
		}
		return value;
	}

	public static void subscribe() throws Exception {
		new Thread(new Runnable() {
			public void run() {
				try {
					Jedis jedis = (Jedis) JedisUtil.getPool().getResource();
					jedis.subscribe(JedisUtil.jedisPubSub, "json");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
	

	public static long getCurrentTime() {
		String timeStr = JedisUtil.get("SYS_TIME");
		long current = Long.valueOf(timeStr.replaceAll("[^(0-9)]", ""));
		return current;
	}

	public static void main(String[] args) throws Exception {

		try {
			JedisUtil.subscribe();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}
}
