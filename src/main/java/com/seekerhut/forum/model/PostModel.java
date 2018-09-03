package com.seekerhut.forum.model;

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
    private Date datetime;
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
        datetime = new Date();
        isDeleted = false;
        viewLevel = 0;
        replyLevel = 0;
        status = 0;
    }

    public PostModel setValue(JSONObject init) {
        if (init.has("id")) { this.id = init.getLong("id"); }
        if (init.has("title")) { this.title = init.getString("title"); }
        if (init.has("authorId")) { this.authorId = init.getLong("authorId"); }
        if (init.has("content")) { this.content = init.getString("content"); }
        if (init.has("replyLevel")) { this.replyLevel = init.getInt("replyLevel"); }
        if (init.has("viewLevel")) { this.viewLevel = init.getInt("viewLevel"); }
        if (init.has("status")) { this.status = init.getInt("status"); }
        return this;
    }

    public Long getId() {
        return id;
    }

    public PostModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getDatetime() {
        return datetime;
    }

    public PostModel setDatetime(Date datetime) {
        this.datetime = datetime;
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
