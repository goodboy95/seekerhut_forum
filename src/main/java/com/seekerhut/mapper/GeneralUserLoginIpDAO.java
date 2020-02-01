package com.seekerhut.mapper;

import com.seekerhut.model.GeneralUserLoginIp;
import org.springframework.stereotype.Repository;

/**
 * GeneralUserLoginIpDAO继承基类
 */
@Repository
public interface GeneralUserLoginIpDAO extends MyBatisBaseDao<GeneralUserLoginIp, Long> {
}