package com.cloud.food.service;

public interface IRedisService {
    boolean set(String key, String value) throws Exception;

    String get(String key) throws Exception;

    boolean expire(String key, long expire) throws Exception;

    void del(String key) throws Exception;

    void dels(String key) throws Exception;

    void setVal(final String key, final String value, final long timeout) throws Exception;

}
