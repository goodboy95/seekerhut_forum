package com.seekerhut.model.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {
    private String host;
    private Integer port;
    private String password;
    private Integer database;
    private String prefix;
    private Integer poolsize;
    private Integer timeout;

    public RedisConfig() {
        host = "127.0.0.1";
        port = 6379;
        password = "";
        database = 0;
        prefix = "";
        poolsize = 10;
        timeout = 10000;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getDatabase() {
        return database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public Integer getPoolsize() {
        return poolsize;
    }

    public void setPoolsize(Integer poolsize) {
        this.poolsize = poolsize;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }
}
