package com.soft.parent.basic.enums;

/**
 * @Author jiangmb
 * @Time 2018/1/19.
 */
public enum PoolEnum {
    SYSTEM_SEQ(0,"SYSTEM:ZSET:SEQUENS"),//系统序列
    USER_TOKEN(0,"USER:TOKEN"),;
    private final int pool;
    private final String key;

    PoolEnum(int pool, String key) {
        this.pool = pool;
        this.key = key;
    }

    public int getPool() {
        return pool;
    }

    public String getKey() {
        return key;
    }
}
