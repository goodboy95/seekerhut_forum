package com.seekerhut.forum.mapper;

import java.util.List;

import com.seekerhut.forum.model.ReplyModel;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ReplyMapper {

  @Insert("INSERT INTO reply (createTime, isDeleted, postId, authorId, viewLevel, content) VALUES(#{createTime}, #{isDeleted}, #{postId}, #{authorId}, #{viewLevel}, #{content})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void insert(ReplyModel forum);

  @Select("SELECT * FROM reply WHERE id = #{id}")
  ReplyModel findById(long id);

  @Select("SELECT * FROM reply WHERE postId=#{postId} LIMIT #{skips}, #{pageSize}")
  List<ReplyModel> getReplies(long postId, int skips, int pageSize);
}