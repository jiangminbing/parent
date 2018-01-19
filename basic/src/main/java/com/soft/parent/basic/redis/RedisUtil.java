package com.soft.parent.basic.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.Pool;

/**
 * Created by Administrator on 15-10-5.
 */
public class RedisUtil {

    /**
     * 存储key value
     *
     * @param pool  连接池
     * @param key   key
     * @param value string值
     * @return 操作结果
     */
    public static boolean saveString(Pool<Jedis> pool, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String res = jedis.set(key, value);
        } catch (Exception e) {
            close(jedis);
            return false;
        } finally {
            close(jedis);
        }
        return true;
    }


    /**
     * 存储key value
     *
     * @param pool  连接池
     * @param key   key
     * @param value string值
     * @param time  生存时间(分钟)
     * @return 操作结果
     */
    public static boolean saveStringByEx(Pool<Jedis> pool, String key, String value, int time) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String res = jedis.setex(key, time * 60, value);
        } catch (Exception e) {
            close(jedis);
            return false;
        } finally {
            close(jedis);
        }
        return true;
    }


    /**
     * 根据key 获取 value
     *
     * @param pool 连接池
     * @param key  key值
     * @return value值
     */
    public static String getValue(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String res = jedis.get(key);
            return res;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }

    /**
     * 判断key是否存在
     *
     * @param pool 连接池
     * @param key  key值
     * @return value值
     */
    public static boolean keyExists(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.exists(key);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * 删除KEY对应的记录
     *
     * @param pool 连接池
     * @param key  key值
     * @return value值
     */
    public static boolean delKey(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.del(key) > 0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * 批量删除
     *
     * @param pool   池
     * @param preStr 前缀
     */
    public static boolean batchDelKey(Pool<Jedis> pool, String preStr) {
        Jedis jedis = null;
        long i = 0;
        try {
            jedis = pool.getResource(); //获取jedis对象
            Set<String> set = jedis.keys(preStr + "*");
            for (String keyStr : set) {
                i = i + jedis.del(keyStr);
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return i > 0;
    }

    //============set操作============

    /**
     * 存入set
     * @param pool
     * @param key
     * @param element
     * @return
     */
    public static boolean addToSet(Pool<Jedis> pool, String key, String... element) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sadd(key,element)>0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * 判断set中是否存在value的值
     * @param pool
     * @param key
     * @param value
     * @return
     */
    public static boolean valueExist(Pool<Jedis> pool, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.sismember(key,value);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    public static long setLength(Pool<Jedis> pool, String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Long len= jedis.scard(key);
            return len==null?0:len;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return 0;
    }

    /**
     * 从set中移除
     * @param pool
     * @param key
     * @param value
     * @return
     */
    public static boolean delFromSet(Pool<Jedis> pool, String key, String... value) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.srem(key,value)>0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * 获取set中所有的值
     * @param pool
     * @param key
     * @return
     */
    public static List<String> getAllFromSet(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return new ArrayList<>(jedis.smembers(key));
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }
    //============zset操作============

    /**
     * Zset操作 ，向 key的 zset中存储的 element 元素，member为权重值
     *
     * @param pool    连接池
     * @param key     zset的key
     * @param element 数据
     * @param score   权重
     * @return 操作结果
     */
    public static boolean addToZset(Pool<Jedis> pool, String key, String element, double score) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zadd(key, score, element) > 0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * Zset操作 删除key对应的zset中的元素 element
     *
     * @param pool    池
     * @param key     zset对应的key
     * @param element 元素
     * @return 操作结果
     */
    public static boolean delToZset(Pool<Jedis> pool, String key, String element) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zrem(key, element) > 0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * RedisUtil
     * zset操作，更改key的zset中的value元素对应的权重值
     *
     * @param pool
     * @param key     zset对应的key
     * @param element zset中的元素
     * @param member  需要改变的值，可以为负数
     * @return 操作结果
     */
    public static boolean changeIncrement(Pool<Jedis> pool, String key, String element, double member) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zincrby(key, member, element) > 0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }


    /**
     * Zset操作 从key对应的zset中按照排序方式和上下标获取对应的元素值
     *
     * @param pool  池
     * @param type  排序方式 1 从小到达 2从大到小
     * @param key   zset对应的key
     * @param start 开始
     * @param end   结束 如果需要取所有 则 上下标传入 0 ,-1
     * @return 集合
     */
    public static List<String> getElementByLimit(Pool<Jedis> pool, int type, String key, int start, int end) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            if (type == 1) {
                return new ArrayList<>(jedis.zrange(key, start, end));
            } else if (type == 2) {
                return new ArrayList<>(jedis.zrevrange(key, start, end));
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }


    /**
     * 判断是否存在
     * @param pool
     * @param key
     * @param element
     * @return
     */
    public static boolean zrank(Pool<Jedis> pool, String key, String element) {
        Jedis jedis = null;

        try {
            jedis = pool.getResource();
            Long zrank = jedis.zrank(key, element);
            if (zrank==null){
                return false;
            }else {
                return true;
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }





    /**
     * 获取zset中元素对应的权重值
     *
     * @param pool    池
     * @param key     zset对应的key
     * @param element 元素
     * @return 元素对应的权重值
     */
    public static Double getScoreByElement(Pool<Jedis> pool, String key, String element) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.zscore(key, element);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }


    //=========================map操作============================

    /**
     * map操作 ，存入一个map，key为键值
     *
     * @param pool 连接池
     * @param key  map的key
     * @param map  数据
     * @return 操作结果
     */
    public static boolean addToMap(Pool<Jedis> pool, String key, Map<String, String> map) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            String result = jedis.hmset(key, map);
            return result.equals("OK");
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }


    /**
     * 将名称为key的hash中field的value增加
     *
     * @param pool 连接池
     * @param key  
     * @param field （map的key）
     * @param value 增加数
     * @param seconds 失效时间
     * @return 增加结果，如果异常返回-1
     */
    public static int hincrby(Pool<Jedis> pool, String key,String field,int value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.expire(key, seconds);
            Long l= jedis.hincrBy(key, field, value);
            return l.intValue();
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return -1;
    }
    
    /**
     * 获取map所有的key
     *
     * @param pool 池
     * @param key  存map对应的key
     * @return map中所有的key
     */
    public static List<String> getAllKeyFromMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return new ArrayList<>(jedis.hkeys(key));
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return new ArrayList<>();
    }

    /**
     * 获取保存的map
     * @param pool
     * @param key
     * @return
     */
    public static Map<String,String> getMap(Pool<Jedis> pool, String key){
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hgetAll(key);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }

    /**
     * 获取map所有的value
     *
     * @param pool 池
     * @param key  存map对应的key
     * @return map中所有的value
     */
    public static List<String> getAllValueFromMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return new ArrayList<>(jedis.hvals(key));
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return new ArrayList<>();
    }

    /**
     * 获取map中的数据长度
     *
     * @param pool 池
     * @param key  存map对应的key
     * @return 长度
     */
    public static int getCountFromMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Long len = jedis.hlen(key);
            return len == null ? 0 : len.intValue();
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return 0;
    }


    private static void close(Jedis jedis){
        if(jedis!=null){
            jedis.close();
        }
    }

    
    /**
     * 获取map中 key对应的值
     * @param pool
     * @param key
     * @return
     */
    public static Map<String, String>  getValueFromMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            Map<String, String> map = jedis.hgetAll(key);
            return map;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }
    
    /**
     * 获取map中 key对应的值
     * @param pool
     * @param key
     * @param name
     * @return
     */
    public static String getValueFromMap(Pool<Jedis> pool, String key,String name) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            List<String> list = jedis.hmget(key, name);
            return (list==null||list.isEmpty())?null:list.get(0);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }

    /**
     * 删除map中key对应的值
     * @param pool
     * @param key
     * @param name
     * @return
     */
    public static boolean delKeyFromMap(Pool<Jedis> pool, String key,String name) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hdel(key,name)>0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }


    /**
     * 删除map中key对应的值
     * @param pool
     * @param key
     * @return
     */
    public static boolean delKeyFromMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.hdel(key)>0;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }
    
    /**
     * 获取库里面的所有对象
     *
     * @param pool 池
     * @param key  前缀
     * @return 所有对象的json字符集
     */
    public static List<String> getValues(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        List<String> list = new ArrayList<String>();    //声明一个装对象字符集的容器
        /*获取所有以key为前缀的所有的主键名*/
        try {
            jedis = pool.getResource(); //获取jedis对象
            Set<String> keys = jedis.keys(key + "*");   //获取所有对象的主键
            /*循环keys获取所有的对象值*/
            for (String newKey : keys) {
                list.add(jedis.get(newKey));
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return list;
    }

    /**
     * 获取目录下水平位置的所有对象(注：子目录下的对象不获取)
     *
     * @param pool 池
     * @param key  前缀
     * @return 所有对象的json字符集
     */
    public static List<String> getLevelValues(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        List<String> list = new ArrayList<String>();    //声明一个装对象字符集的容器
        /*获取所有以key为前缀的所有的主键名*/
        try {
            jedis = pool.getResource(); //获取jedis对象
            Set<String> keys = jedis.keys(key + "*");   //获取所有对象的主键
            /*循环keys获取所有的对象值*/
            for (String newKey : keys) {
                //如果newKey和key的最后一个":"的位置相等就为目录下的对象（非子目录下的对象）;
                if (newKey.lastIndexOf(":") == key.lastIndexOf(":")) {
                    list.add(jedis.get(newKey));
                }
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return list;
    }

    /**
     * 获取目录下水平位置的键值队(注：子目录下的对象不获取)
     *
     * @param pool 池
     * @param key  前缀
     * @return 所有对象的键值队
     */
    public static Map<String, Object> getRedisMap(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        Map<String, Object> map = new HashMap<>(); //声明map保存结果
        /*获取所有以key为前缀的所有的主键名*/
        try {
            jedis = pool.getResource(); //获取jedis对象
            Set<String> keys = jedis.keys(key + "*");   //获取所有对象的主键
            /*循环keys获取所有的对象值*/
            for (String newKey : keys) {
                //如果newKey和key的最后一个":"的位置相等就为目录下的对象（非子目录下的对象）;
                if (newKey.lastIndexOf(":") == key.lastIndexOf(":")) {
                    map.put(newKey, jedis.get(newKey));
                }
            }
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return map;
    }

    /**
     * 设置key的过期时间
     *
     * @param pool 池
     * @param key  存map对应的key
     * @param time 过期时间
     */
    public static void expireKey(Pool<Jedis> pool, String key,Integer time) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.expire(key, time);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
    }

    /**
     * 判断是否已经存在
     * @param pool
     * @param key
     * @return
     */
    public static boolean isExist(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            boolean flag = jedis.exists(key.getBytes());
            return flag;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    /**
     * 获取数据
     * @param pool
     * @param key
     * @return
     */
    public static byte[] getRedisObject(Pool<Jedis> pool, String key) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            byte[] bytes = jedis.get(key.getBytes());
            return bytes;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return null;
    }

    /**
     * 更新数据
     * @param pool
     * @param key
     * @return
     */
    public static void saveOrUpdateRedisObject(Pool<Jedis> pool, String key, byte[] bytes) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set(key.getBytes(), bytes);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
    }

    public static boolean setNx(JedisPool pool, String key, String expiresStr) {
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            return jedis.setnx(key, expiresStr)==1;
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return false;
    }

    public static String getSet(JedisPool pool, String key, String value) {
    	String returns=null;
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            returns=jedis.getSet(key,value);
        } catch (Exception e) {
            close(jedis);
        } finally {
            close(jedis);
        }
        return returns;
    }
}
