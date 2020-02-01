package com.seekerhut.mapper;

import com.seekerhut.model.GeneralFileMetadata;
import org.springframework.stereotype.Repository;

/**
 * GeneralFileMetadataDAO继承基类
 */
@Repository
public interface GeneralFileMetadataDAO extends MyBatisBaseDao<GeneralFileMetadata, Long> {
}