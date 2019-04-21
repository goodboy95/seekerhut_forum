package com.seekerhut.forum.map;

import com.seekerhut.forum.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface PostMap extends JpaRepository<PostModel, Long> {
    @Query(value = "select * from post where forum_id = ?1 limit ?2, ?3", nativeQuery = true)
    public List<PostModel> getPosts(Long forumId, int skips, int limit);
}
