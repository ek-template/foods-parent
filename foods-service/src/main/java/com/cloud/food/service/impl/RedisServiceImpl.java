package com.cloud.food.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.log.StaticLog;
import com.cloud.food.service.IRedisService;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Title RedisServiceImpl
 * @Author qierkang xyqierkang@163.com
 * @Date Created in 2019-04-13 18:57
 * @Description [ 一句话描述是什么作用 ]
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class RedisServiceImpl implements IRedisService {

    /**
     * Redis Prefix
     * <p>
     * 在Redis存放用户信息区分前缀
     */
    private static final String FILE_INFO_PREFIX = "FILE_INFO:";

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean set(final String key, final String value) {
        boolean result = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            connection.set(serializer.serialize(key), serializer.serialize(value));
            return true;
        });
        return result;
    }

    /**
     * @param @param  key
     * @param @param  value
     * @param @param  timeout
     * @param @throws Exception    设定文件
     * @throws
     * @Title: RedisServiceImpl.java
     * @author qierkang xyqierkang@163.com
     * @date 2018年5月23日 下午11:38:06
     * @Description: TODO[ 这里用一句话描述这个方法的作用 ]
     */
    @Override
    public void setVal(final String key, final String value, final long timeout) {
//          MICROSECONDS    微秒   一百万分之一秒（就是毫秒/1999）
//          MILLISECONDS    毫秒   千分之一秒    
//          NANOSECONDS   毫微秒  十亿分之一秒（就是微秒/1999）
//          SECONDS          秒
//          MINUTES     分钟
//          HOURS      小时
//          DAYS      天
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public String get(final String key) {
        String result = redisTemplate.execute((RedisCallback<String>) connection -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            byte[] value = connection.get(serializer.serialize(key));
            return serializer.deserialize(value);
        });
        return result;
    }

    @Override
    public void del(final String key) {
        redisTemplate.execute((RedisCallback<Long>) conn -> {
            RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
            return conn.del(serializer.serialize(key));
        });
    }

    @Override
    public void dels(String key) {
        Set<String> keys = redisTemplate.keys("*" + key + "*");
        if (ObjectUtil.isNotEmpty(keys)) {
            StaticLog.info("模糊删除key*》[{}]", keys);
            redisTemplate.delete(keys);
        }
    }


    @Override
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }


    /**
     * 获取一个对象
     *
     * @param key key
     * @return object
     */
    public Object getUser(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取一个对象类型数据
     *
     * @param key key
     * @return object
     */
    public <T> T getObject(String key, Class<T> clazz) {
        Object obj = getUser(key);
        return obj == null ? null : (T) obj;
    }

//    @Override
//    public CustBaseinfo getCustLogin(String token) {
//        if (CommonUtil.isNullStr(token)) {
//            throw new YmeifenException(ResultEnum.result_999998.getKey(), ConstantInterface.LoginValidate.LOGIN_200300.getValue());
//        }
//        CustBaseinfo custBaseinfo = getObject(StringUtil.splicing(LOGIN_USER_INFO_PREFIX, token), CustBaseinfo.class);
//        if (custBaseinfo == null) {
//            throw new YmeifenException("获取用户信息失败 用户数据为空");
//        }
//        return custBaseinfo;
//    }

}
