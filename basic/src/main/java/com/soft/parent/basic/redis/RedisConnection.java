package com.soft.parent.basic.redis;


import java.util.HashMap;

import javax.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Administrator on 15-10-4.
 */
@Repository("redisConnection")
public class RedisConnection{
    private Logger logger = LoggerFactory.getLogger("redisConnection");

    private HashMap<Integer, JedisPool> messagePoolMaps = new HashMap<Integer, JedisPool>();

    @Value("${spring.redis.pool.max-active}")
    private int maxActive;
    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;
    @Value("${spring.redis.pool.max-wait}")
    private long maxWait;
    @Value("${spring.redis.pool.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${spring.redis.pool.testOnReturn}")
    private boolean testOnReturn;
    @Value("${spring.redis.database}")
    private int databases;
    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.password}")
    private String passwd;

    @PostConstruct
    public void init() {
        try {
            passwd= StringUtils.isEmpty(passwd)?null:passwd;
            JedisPoolConfig config = new JedisPoolConfig();
            // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
            config.setBlockWhenExhausted(true);
            // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
            config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
            // 是否启用pool的jmx管理功能, 默认true
            config.setJmxEnabled(true);
            // 最大空闲连接数, 默认8个 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            config.setMaxIdle(maxIdle);
            // 最大连接数, 默认8个
            config.setMaxTotal(maxActive);
            // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            config.setMaxWaitMillis(maxWait);
            // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            config.setTestOnBorrow(testOnBorrow);
            for (int i = 0; i < databases; i++) {
                messagePoolMaps.put(i, new JedisPool(config, host,
                        port, 3000,passwd, i));
            }
            test();
        } catch (Exception e) {
        	logger.error(JSONObject.toJSONString(e));
            e.printStackTrace();
        }

    }

    /**
     * 根据KEY获取一个系统分配的pool
     *
     * @param key 一般是主键
     * @return pool
     */
    public JedisPool getJedisPool(int key) {
        if (key < 0)
            key -= key;
        if (key > 10) {
            key = key % 10;
        }
        return messagePoolMaps.get(key);
    }

    /**
     * 获取一个指定的pool
     *
     * @param db 库的编号 不能超过设置中的 redis.databases
     * @return pool
     */
    public JedisPool getPool(int db) {
        if (db > databases) {
            return null;
        }
        return messagePoolMaps.get(db);
    }

    /**
     * 测试是否连接成功
     */
    private void test(){
        JedisPool pool=getJedisPool(0);
        RedisUtil.saveString(pool,"test","test");
        pool=getJedisPool(0);
        String re=RedisUtil.getValue(pool,"test");
        if(re==null||!re.equals("test")){
            logger.error("#########连接redis失败!!!!!");
        }else{
            logger.info("redis连接成功");
            RedisUtil.delKey(pool,"test");
        }
    }

}
