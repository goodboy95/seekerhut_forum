package com.seekerhut.forum.mapper;

import java.util.List;

import com.seekerhut.forum.model.PostModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface PostMapper {

  @Insert("INSERT INTO post (createTime, isDeleted, forumId, title, authorId, viewLevel, replyLevel, content, status) VALUES(#{createTime}, #{isDeleted}, #{forumId}, #{title}, #{authorId}, #{viewLevel}, #{replyLevel}, #{content}, #{status})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(PostModel forum);

  @Select("SELECT * FROM post WHERE id = #{id}")
  PostModel findById(long id);

  @Select("SELECT * FROM post WHERE forumId=#{forumId} LIMIT #{skips}, #{pageSize}")
  List<PostModel> getPosts(long forumId, int skips, int pageSize);
}