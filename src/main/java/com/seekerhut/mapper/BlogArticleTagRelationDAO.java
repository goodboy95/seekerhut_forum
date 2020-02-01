package com.seekerhut.mapper;

import com.seekerhut.model.BlogArticleTagRelation;
import org.springframework.stereotype.Repository;

/**
 * BlogArticleTagRelationDAO继承基类
 */
@Repository
public interface BlogArticleTagRelationDAO extends MyBatisBaseDao<BlogArticleTagRelation, Long> {
}