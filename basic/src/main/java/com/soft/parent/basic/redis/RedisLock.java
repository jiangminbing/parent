package com.soft.parent.basic.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.JedisPool;

import java.util.Random;

/**
 * redis分布式锁
 */
public class RedisLock {

    private Logger logger= LoggerFactory.getLogger("lock");


    /**
     * 保存在redis中的key
     */
    private static final String redisKey="LOCK:STRING:KEY:";

    /**
     * 睡眠时间
     */
    private static final int DEFAULT_ACQUIRY_RESOLUTION_MILLIS = 100;
    /**
     * 锁超时时间，防止线程在入锁以后，无限的执行等待
     */
    private int expireMsecs = 60 * 1000;

    /**
     * 锁等待时间，防止线程饥饿
     */
    private int timeoutMsecs = 10 * 1000;


    public JedisPool pool;

    public static final Random r = new Random();


    private String lockKey;
    //锁状态标志
    private boolean locked = false;

    public RedisLock(String lockKey, JedisPool pool) {
        this.lockKey = redisKey+lockKey;
        this.pool = pool;
    }

    /**
     *
     * @param lockKey 锁标记
     * @param pool 池
     * @param timeoutMsecs 锁等待时间
     */
    public RedisLock(String lockKey, JedisPool pool, int timeoutMsecs) {
        this(lockKey,pool);
        this.timeoutMsecs = timeoutMsecs;
    }

    /**
     *
     * @param lockKey 锁标记
     * @param pool 池
     * @param timeoutMsecs 锁等待时间
     * @param expireMsecs  锁失效时间
     */
    public RedisLock(String lockKey, JedisPool pool, int timeoutMsecs, int expireMsecs) {
        this(lockKey,pool, timeoutMsecs);
        this.expireMsecs = expireMsecs;
    }

    public boolean lock(long timeout) {
        try {
            int i=1;
            while (timeout >= 0) {
                long expires = System.currentTimeMillis() + expireMsecs + 1;
                String expiresStr = String.valueOf(expires); //锁到期时间
                if (RedisUtil.setNx(pool, lockKey, expiresStr)) {
                    logger.info("获取到了锁");
                    locked = true;
                    return true;
                }else{
                    String currentValueStr = RedisUtil.getValue(pool, lockKey);
                    if (currentValueStr != null && Long.parseLong(currentValueStr) < System.currentTimeMillis()) {
                        //判断是否为空，不为空的情况下，如果被其他线程设置了值，则第二个条件判断是过不去的
                        // lock is expired
                        String oldValueStr = RedisUtil.getSet(pool, lockKey, expiresStr);
                        //获取上一个锁到期时间，并设置现在的锁到期时间，
                        //只有一个线程才能获取上一个线上的设置时间，因为jedis.getSet是同步的
                        if (oldValueStr != null && oldValueStr.equals(currentValueStr)) {
                            //防止误删（覆盖，因为key是相同的）了他人的锁——这里达不到效果，这里值会被覆盖，但是因为什么相差了很少的时间，所以可以接受

                            //[分布式的情况下]:如过这个时候，多个线程恰好都到了这里，但是只有一个线程的设置值和当前值相同，他才有权利获取锁
                            // lock acquired
                            locked = true;
                            return true;
                        }
                    }
                    timeout -= DEFAULT_ACQUIRY_RESOLUTION_MILLIS;
                    /*
                        延迟100 毫秒,  这里使用随机时间可能会好一点,可以防止饥饿进程的出现,即,当同时到达多个进程,
                        只会有一个进程获得锁,其他的都用同样的频率进行尝试,后面有来了一些进行,也以同样的频率申请锁,这将可能导致前面来的锁得不到满足.
                        使用随机的等待时间可以一定程度上保证公平性
                     */
                    logger.info("未获取到锁，第{}次休眠",i);
                    // 短暂休眠，nano避免出现活锁
                    i++;
                    Thread.sleep(DEFAULT_ACQUIRY_RESOLUTION_MILLIS);
                }

            }
        } catch (Exception e) {
            logger.info("发生异常:{}",e);
        }
        logger.info("超时返回!!!");
        return false;
    }
    public boolean lock() {
        return lock(timeoutMsecs);
    }

    // 无论是否加锁成功，必须调用
    public void unlock() {
        if(locked){
            RedisUtil.delKey(pool, lockKey);
        }
    }

    /**
     * 加锁
     * @param locaName  锁的key
     * @param acquireTimeout  获取超时时间
     * @param timeout   锁的超时时间
     * @return 锁标识
     *//*
    public String lockWithTimeout(String locaName,
                                  long acquireTimeout, long timeout) {
        Jedis conn = null;
        String retIdentifier;
        try {
            // 获取连接
            conn = jedisPool.getResource();
            // 随机生成一个value
            String identifier = UUID.randomUUID().toString();
            // 锁名，即key值
            String lockKey = "lock:" + locaName;
            // 超时时间，上锁后超过此时间则自动释放锁
            int lockExpire = (int)(timeout / 1000);

            // 获取锁的超时时间，超过这个时间则放弃获取锁
            long end = System.currentTimeMillis() + acquireTimeout;
            while (System.currentTimeMillis() < end) {
                if (conn.setnx(lockKey, identifier) == 1) {
                    conn.expire(lockKey, lockExpire);
                    // 返回value值，用于释放锁时间确认
                    retIdentifier = identifier;
                    return retIdentifier;
                }
                // 返回-1代表key没有设置超时时间，为key设置一个超时时间
                if (conn.ttl(lockKey) == -1) {
                    conn.expire(lockKey, lockExpire);
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return null;
    }

    *//**
     * 释放锁
     * @param lockName 锁的key
     * @param identifier    释放锁的标识
     * @return
     *//*
    public boolean releaseLock(String lockName, String identifier) {
        Jedis conn = null;
        String lockKey = "lock:" + lockName;
        boolean retFlag = false;
        try {
            conn = jedisPool.getResource();
            while (true) {
                // 监视lock，准备开始事务
                conn.watch(lockKey);
                // 通过前面返回的value值判断是不是该锁，若是该锁，则删除，释放锁
                if (identifier.equals(conn.get(lockKey))) {
                    Transaction transaction = conn.multi();
                    transaction.del(lockKey);
                    List<Object> results = transaction.exec();
                    if (results == null) {
                        continue;
                    }
                    retFlag = true;
                }
                conn.unwatch();
                break;
            }
        } catch (JedisException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return retFlag;
    }*/
}
