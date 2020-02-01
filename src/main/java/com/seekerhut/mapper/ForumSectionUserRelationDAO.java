package com.seekerhut.mapper;

import com.seekerhut.model.ForumSectionUserRelation;
import org.springframework.stereotype.Repository;

/**
 * ForumSectionUserRelationDAO继承基类
 */
@Repository
public interface ForumSectionUserRelationDAO extends MyBatisBaseDao<ForumSectionUserRelation, Long> {
}