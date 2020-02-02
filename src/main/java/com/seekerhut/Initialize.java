package com.seekerhut;

import com.seekerhut.model.config.RedisConfig;
import com.seekerhut.utils.JedisHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.core.annotation.Order;

@Component
@Order(1)
public class Initialize implements ApplicationRunner {
    @Autowired
    private RedisConfig redisConfig;

    public void run(ApplicationArguments args) throws Exception {
        JedisHelper.init(redisConfig);
    }
}
