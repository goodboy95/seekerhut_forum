package com.seekerhut.mapper;

import com.seekerhut.model.ForumSection;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ForumSectionDAO继承基类
 */
@Repository
public interface ForumSectionDAO extends MyBatisBaseDao<ForumSection, Integer> {
    List<ForumSection> getList(@Param("skip") int skip, @Param("take") int take);
}