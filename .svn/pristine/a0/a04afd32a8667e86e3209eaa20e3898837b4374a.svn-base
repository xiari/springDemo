package com.demo.mvc.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by XYY78 on 2016/9/18.
 */
@Service
public class RedisClientUtils {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    // 增加
    public void add(String key, Object object){
        redisTemplate.opsForValue().set(key, object);
    }

    // 查询
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    // 删除
    public void delete(String key ){
        redisTemplate.delete(key);
    }

    // 更新
    public void update(String key , Object object){
        redisTemplate.opsForValue().set(key,object);
    }

    public void lAddList(String key, Object object){
        redisTemplate.opsForList().leftPush(key, object);
    }

    public Object getList(String key){
        Long size =  redisTemplate.opsForList().size(key);
        return redisTemplate.opsForList().range(key, 0, size);
    }
}
