package com.seekerhut.forum.model;

import java.io.Serializable;

public class ReplyModel extends ModelBase implements Serializable {
    private Long postId;
    private Long authorId;
    private int viewLevel;
    private String content;

    public ReplyModel() {
        super();
        viewLevel = 0;
    }

    /**
     * @return the postId
     */
    public Long getPostId() {
        return postId;
    }

    /**
     * @param postId the postId to set
     */
    public void setPostId(Long postId) {
        this.postId = postId;
    }

    /**
     * @return the authorId
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * @param authorId the authorId to set
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * @return the viewLevel
     */
    public int getViewLevel() {
        return viewLevel;
    }

    /**
     * @param viewLevel the viewLevel to set
     */
    public void setViewLevel(int viewLevel) {
        this.viewLevel = viewLevel;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    
}
