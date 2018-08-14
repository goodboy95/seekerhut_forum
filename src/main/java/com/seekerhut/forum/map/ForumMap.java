package com.seekerhut.forum.map;
import com.seekerhut.forum.model.ForumModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ForumMap extends JpaRepository<ForumModel, Long> {
    List<ForumModel> findByName(String name);
    List<ForumModel> findTop2ByAdminName(String name);
   // @Query("select f from forum f where name = ?1 setMaxResults ?2")
    @Query(value = "select * from forum where name = ?1 limit ?2", nativeQuery = true)
    List<ForumModel> findSomeByName(String name, int limit);
}
