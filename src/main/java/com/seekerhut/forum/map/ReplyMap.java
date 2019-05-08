package com.seekerhut.forum.map;

import com.seekerhut.forum.model.ReplyModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ReplyMap extends JpaRepository<ReplyModel, Long>, JpaSpecificationExecutor<ReplyModel> {
    @Query(value = "select * from reply where postId = ?1 limit ?2, ?3", nativeQuery = true)
    List<ReplyModel> getReply(Long postId, int skips, int limit);

}
