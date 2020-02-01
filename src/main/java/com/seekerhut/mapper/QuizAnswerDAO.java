package com.seekerhut.mapper;

import com.seekerhut.model.QuizAnswer;
import org.springframework.stereotype.Repository;

/**
 * QuizAnswerDAO继承基类
 */
@Repository
public interface QuizAnswerDAO extends MyBatisBaseDao<QuizAnswer, Long> {
}