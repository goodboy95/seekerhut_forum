package com.seekerhut.utils;

import com.seekerhut.model.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@EnableConfigurationProperties(RedisConfig.class)
public class JedisHelper {
    private static JedisPool jedisPool;
    private static JedisPoolConfig jedisPoolConfig;
    private static String prefix;

    public static void init(RedisConfig redisConfig) {
        String host = redisConfig.getHost();
        int port = redisConfig.getPort();
        String password = redisConfig.getPassword();
        int database = redisConfig.getDatabase();
        int timeout = redisConfig.getTimeout();
        int poolsize = redisConfig.getPoolsize();
        jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(poolsize);
        jedisPoolConfig.setMinIdle(0);
        jedisPoolConfig.setMaxIdle(poolsize);
        jedisPool = password.equals("")
            ? new JedisPool(jedisPoolConfig, host, port, timeout, null, database)
            : new JedisPool(jedisPoolConfig, host, port, timeout, password, database);
        prefix = redisConfig.getPrefix() + ":";
    }

    public static void set(String key, Object val) {
        key = prefix + key;
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, val.toString());
        jedis.close();
    }

    public static String get(String key) {
        key = prefix + key;
        Jedis jedis = jedisPool.getResource();
        String result = jedis.get(key);
        jedis.close();
        return result;
    }

    public static void hset(String key, Object hashKey, Object val) {
        key = prefix + key;
        Jedis jedis = jedisPool.getResource();
        jedis.hset(key, hashKey.toString(), val.toString());
        jedis.close();
    }

    public static String hget(String key, String hashKey) {
        key = prefix + key;
        Jedis jedis = jedisPool.getResource();
        String result = jedis.hget(key, hashKey);
        jedis.close();
        return result;
    }
}
