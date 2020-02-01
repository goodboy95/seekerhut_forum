package com.seekerhut.mapper;

import com.seekerhut.model.ForumPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ForumPostDAO继承基类
 */
@Repository
public interface ForumPostDAO extends MyBatisBaseDao<ForumPost, Long> {
    List<ForumPost> getList(@Param("forumId") Long forumId, @Param("skip") int skip, @Param("take") int take);
}