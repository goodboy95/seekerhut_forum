package com.seekerhut.mapper;

import com.seekerhut.model.BlogTag;
import org.springframework.stereotype.Repository;

/**
 * BlogTagDAO继承基类
 */
@Repository
public interface BlogTagDAO extends MyBatisBaseDao<BlogTag, Long> {
}