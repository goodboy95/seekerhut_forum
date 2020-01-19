package com.seekerhut.forum.model;

import java.io.Serializable;

public class PostModel extends ModelBase implements Serializable {
    private int forumId;
    private String title;
    private Long authorId;
    private int viewLevel;
    private int replyLevel;
    private String content;
    private int status;

    public PostModel() {
        super();
        viewLevel = 0;
        replyLevel = 0;
        status = 0;
    }

    public int getForumId() {
        return forumId;
    }

    public PostModel setForumId(int forumId) {
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
