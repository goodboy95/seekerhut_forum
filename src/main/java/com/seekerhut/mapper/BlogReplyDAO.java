package com.seekerhut.mapper;

import com.seekerhut.model.BlogReply;
import org.springframework.stereotype.Repository;

/**
 * BlogReplyDAO继承基类
 */
@Repository
public interface BlogReplyDAO extends MyBatisBaseDao<BlogReply, Long> {
}