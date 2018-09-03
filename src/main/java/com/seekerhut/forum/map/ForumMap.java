package com.seekerhut.forum.map;
import com.seekerhut.forum.model.ForumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.awt.print.Pageable;
import java.util.List;

public interface ForumMap extends JpaRepository<ForumModel, Long>, JpaSpecificationExecutor<ForumModel> {
    @Query(value = "select * from forum limit ?1, ?2", nativeQuery = true)
    List<ForumModel> getForums(int skips, int limit);

}
