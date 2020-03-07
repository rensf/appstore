package com.sys.appstore.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis 工具类
 */
@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     *设定过期时间
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key, long time) {
        return redisTemplate.expire(key, time, TimeUnit.SECONDS);
    }

    /**
     * 通过key获取过期时间
     * @param key
     * @return
     */
    public long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     *判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 通过key删除缓存
     * @param key 一个或多个
     * @return
     */
    public long del(String... key) {
        return redisTemplate.delete(CollectionUtils.arrayToList(key));
    }

    /**********         String         ***********/
    /**
     * 通过key获取值
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置指定key的值
     * @param key
     * @param value
     */
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置指定key的值并设置过期时间
     * @param key
     * @param value
     * @param time
     */
    public void set(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
    }

    /**
     * 将key所储存的值加上给定的增量值
     * @param key
     * @param delta
     * @return
     */
    public long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 将key所储存的值减去给定的减量值
     * @param key
     * @param delta
     * @return
     */
    public long decr(String key, long delta) {
        return redisTemplate.opsForValue().decrement(key, delta);
    }

    /**********         Map         ***********/
    /**
     * 通过key获取存储在哈希表中的值
     * @param key
     * @param item
     * @return
     */
    public Object hGet(String key, String item) {
        return redisTemplate.opsForHash().get(key, item);
    }

    /**
     * 通过key获取存储在哈希表中的所有键和值
     * @param key
     * @return
     */
    public Map<Object, Object> hmGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 将key所对应的哈希表中item字段对应的值设置为value
     * @param key
     * @param item
     * @param value
     */
    public void hSet(String key, String item, Object value) {
        redisTemplate.opsForHash().put(key, item, value);
    }

    /**
     * 将key所对应的哈希表中item字段对应的值设置为value并设置过期时间
     * @param key
     * @param item
     * @param value
     * @param time
     */
    public void hSet(String key, String item, Object value, long time) {
        redisTemplate.opsForHash().put(key, item, value);
        expire(key, time);
    }

    /**
     * 向key所对应的哈希表添加map
     * @param key
     * @param map
     */
    public void hmSet(String key, Map<String, Object> map) {
        redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 向key所对应的哈希表添加map并设置过期时间
     * @param key
     * @param map
     * @param time
     */
    public void hmSet(String key, Map<String, Object> map, long time) {
        redisTemplate.opsForHash().putAll(key, map);
        expire(key, time);
    }

    /**
     * 通过key删除哈希表
     * @param key
     * @param item 一个或多个
     * @return
     */
    public long hDel(String key, Object... item) {
        return redisTemplate.opsForHash().delete(key, item);
    }

    /**
     * 将key所对应的哈希表中item字段对应的值加上给定的增量值
     * @param key
     * @param item
     * @param delta
     * @return
     */
    public double hIncr(String key, String item, double delta) {
        return redisTemplate.opsForHash().increment(key, item, delta);
    }

    /**
     * 将key所对应的哈希表中item字段对应的值减去给定的减量值
     * @param key
     * @param item
     * @param delta
     * @return
     */
    public double hDecr(String key, String item, double delta) {
        return redisTemplate.opsForHash().increment(key, item, -delta);
    }

    /**
     * 判断key所对应的哈希表中item是否存在
     * @param key
     * @param item
     * @return
     */
    public boolean hHasKey(String key, String item) {
        return redisTemplate.opsForHash().hasKey(key, item);
    }

    /**********         Set         ***********/
    /**
     * 通过key获取set中所有值
     * @param key
     * @return
     */
    public Set<Object> sGet(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * 判断key所对应set中是否存在value
     * @param key
     * @param value
     * @return
     */
    public boolean sHasKey(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 向key所对应的set添加value
     * @param key
     * @param values
     */
    public void sSet(String key, Object... values) {
        redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 向key所对应的set添加value并设置过期时间
     * @param key
     * @param time
     * @param values
     */
    public void sSet(String key, long time, Object... values) {
        redisTemplate.opsForSet().add(key, values);
        expire(key, time);
    }

    /**
     * 获取key所对应set的长度
     * @param key
     * @return
     */
    public long sGetSetSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 删除key所对应set中的值
     * @param key
     * @param values
     * @return
     */
    public long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**********         List         ***********/
    /**
     * 通过key获取list中的值
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<Object> lGet(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 通过key获取list中index对应的值
     * @param key
     * @param index
     * @return
     */
    public Object lGetByIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }

    /**
     * 向key对应的list中添加值
     * @param key
     * @param values
     */
    public void lSet(String key, List<Object> values) {
        redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 向key对应的list中添加值并设置过期时间
     * @param key
     * @param values
     * @param time
     */
    public void lSet(String key, List<Object> values, long time) {
        redisTemplate.opsForList().rightPushAll(key, values);
        expire(key, time);
    }

    /**
     * 获取key所对应list的长度
     * @param key
     * @return
     */
    public long lGetListSize(String key) {
        return redisTemplate.opsForList().size(key);
    }

    /**
     * 通过key更改list中index对应的值
     * @param key
     * @param index
     * @param value
     */
    public void lUpdateByIndex(String key, long index, Object value) {
        redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 将key对应的list中的count个value删除
     * @param key
     * @param count
     * @param value
     * @return
     */
    public long lRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }
}
