package com.seekerhut.mapper;

import com.seekerhut.model.GeneralCommondata;
import org.springframework.stereotype.Repository;

/**
 * GeneralCommondataDAO继承基类
 */
@Repository
public interface GeneralCommondataDAO extends MyBatisBaseDao<GeneralCommondata, Long> {
}