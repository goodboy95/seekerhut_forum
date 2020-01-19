package com.seekerhut.forum.mapper;

import com.seekerhut.forum.model.ForumModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ForumMapper {

  @Insert("INSERT INTO forum (createTime, isDeleted, name, creatorId, viewLevel, postLevel, status, adminId, adminName) VALUES(#{createTime}, #{isDeleted}, #{name}, #{creatorId}, #{viewLevel}, #{postLevel}, #{status}, #{adminId}, #{adminName})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(ForumModel forum);

  @Select("SELECT * FROM forum WHERE id = #{id}")
  ForumModel findById(int id);

  @Select("SELECT * FROM forum")
  ForumModel findAll();
}