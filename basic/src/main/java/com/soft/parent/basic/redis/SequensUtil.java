package com.soft.parent.basic.redis;

import com.soft.parent.basic.enums.PoolEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import redis.clients.jedis.JedisPool;

/**
 * Created by fengbo on 16-10-8.
 */
@Service("sequensUtil")
public class SequensUtil {


    private static final String KEY = PoolEnum.SYSTEM_SEQ.getKey();
    private static final int POOL= PoolEnum.SYSTEM_SEQ.getPool();


    private static final String STR = "00000000000000000000000000000000000000";

    @Autowired
    private RedisConnection connection;

    

    /**
     * 生成8位数字型主键的方法 默认的方法
     *
     * @param seqName seq名称，一般是表名
     * @return 8位长度的数字型主键
     */
    public String getNextVal(String seqName) throws Exception {
        return getNextStr(seqName, 8);
    }


    /**
     * 生成N位数字型主键的方法 n=len
     *
     * @param seqName seq名称，一般是表名
     * @param len     需要生成的主键的长度
     * @return n位长度的数字型主键
     */
    public String getNextVal(String seqName, int len) throws Exception {
        return getNextStr(seqName, len);
    }

    /**
     * 获取在 seq中的当前值
     *
     * @param seqName Seq名称
     * @return 当前值，默认8位长度
     * @throws Exception
     */
    public String getCurValue(String seqName) throws Exception {
        return cut(getIntFromRedis(seqName), 8);
    }

    /**
     * 根据key获取int值加一返回，并在redis中自动加一
     *
     * @param seqName seq名称
     * @param len     返回长度
     * @return String值
     * @throws Exception
     */
    private String getNextStr(String seqName, int len) throws Exception {
        int value = getIntFromRedis(seqName);
        JedisPool pool = connection.getJedisPool(POOL);
        RedisUtil.changeIncrement(pool, KEY, seqName, 1);
        return cut(value + 1, len);
    }


    /**
     * 向seq中设置值
     * @param tableName
     * @param value
     * @return
     */
    public boolean saveValue(String tableName,Integer value){
        JedisPool pool = connection.getJedisPool(POOL);
        RedisUtil.delToZset(pool,KEY,tableName);
        pool = connection.getJedisPool(POOL);
        return RedisUtil.addToZset(pool, KEY, tableName, value);
    }


    /**
     * 把数字转换为String，并补足位数
     *
     * @param value 输入数字
     * @return 8位字符串
     */
    private String cut(int value, int len) {
        String str_m = String.valueOf(value);
        if (str_m.length() < len) {
            str_m = STR.substring(0, len - str_m.length()) + str_m;
        }
        return str_m;
    }


    /**
     * 从redis获取seq对应的值并转为int输出
     *
     * @param seqName seq名，一般是表名
     * @return int
     * @throws Exception
     */
    private int getIntFromRedis(String seqName) throws Exception {
        //获取上下文
        JedisPool pool = connection.getJedisPool(POOL);
        //从redis获取值
        Double d = RedisUtil.getScoreByElement(pool, KEY, seqName);
        //如果没有取到，说明原先没有设置这个名称的值，设置一个。
        if (d == null) {
            pool = connection.getJedisPool(POOL);
            RedisUtil.addToZset(pool, KEY, seqName, 0);
            return 0;
        } else {
            return d.intValue();
        }

    }
}
