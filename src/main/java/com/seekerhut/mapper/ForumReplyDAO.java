package com.seekerhut.mapper;

import com.seekerhut.model.ForumPost;
import com.seekerhut.model.ForumReply;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ForumReplyDAO继承基类
 */
@Repository
public interface ForumReplyDAO extends MyBatisBaseDao<ForumReply, Long> {
    List<ForumReply> getList(@Param("postId") Long postId, @Param("skip") int skip, @Param("take") int take);
}

