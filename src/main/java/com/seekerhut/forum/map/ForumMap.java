package com.seekerhut.forum.map;
import com.seekerhut.forum.model.ForumModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumMap extends JpaRepository<ForumModel, Long> {

}
