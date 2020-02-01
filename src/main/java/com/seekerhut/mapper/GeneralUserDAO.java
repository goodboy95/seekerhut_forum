package com.seekerhut.mapper;

import com.seekerhut.model.GeneralUser;
import org.springframework.stereotype.Repository;

/**
 * GeneralUserDAO继承基类
 */
@Repository
public interface GeneralUserDAO extends MyBatisBaseDao<GeneralUser, Long> {
}