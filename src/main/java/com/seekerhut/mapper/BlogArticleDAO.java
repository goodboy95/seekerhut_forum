package com.seekerhut.mapper;

import com.seekerhut.model.BlogArticle;
import org.springframework.stereotype.Repository;

/**
 * BlogArticleDAO继承基类
 */
@Repository
public interface BlogArticleDAO extends MyBatisBaseDao<BlogArticle, Long> {
}