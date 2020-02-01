package com.seekerhut.mapper;

import com.seekerhut.model.QuizQuestion;
import org.springframework.stereotype.Repository;

/**
 * QuizQuestionDAO继承基类
 */
@Repository
public interface QuizQuestionDAO extends MyBatisBaseDao<QuizQuestion, Long> {
}