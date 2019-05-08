package com.seekerhut.forum.model;

import org.json.JSONException;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "post", indexes = {
})
public class PostModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Boolean isDeleted;
    @Column(nullable = false)
    private Long forumId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Long authorId;
    @Column(nullable = false)
    private int viewLevel;
    @Column(nullable = false)
    private int replyLevel;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private int status;

    public PostModel() {
        createTime = new Date();
        isDeleted = false;
        viewLevel = 0;
        replyLevel = 0;
        status = 0;
    }

    public Long getId() {
        return id;
    }

    public PostModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public PostModel setCreatetime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public PostModel setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public Long getForumId() {
        return forumId;
    }

    public PostModel setForumId(Long forumId) {
        this.forumId = forumId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public PostModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public PostModel setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    public int getViewLevel() {
        return viewLevel;
    }

    public PostModel setViewLevel(int viewLevel) {
        this.viewLevel = viewLevel;
        return this;
    }

    public int getReplyLevel() {
        return replyLevel;
    }

    public PostModel setReplyLevel(int replyLevel) {
        this.replyLevel = replyLevel;
        return this;
    }

    public String getContent() {
        return content;
    }

    public PostModel setContent(String content) {
        this.content = content;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public PostModel setStatus(int status) {
        this.status = status;
        return this;
    }
}
