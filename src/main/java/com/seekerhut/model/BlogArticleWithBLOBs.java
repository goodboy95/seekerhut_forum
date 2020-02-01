package com.seekerhut.model;

import java.io.Serializable;

/**
 * blog_article
 * @author 
 */
public class BlogArticleWithBLOBs extends BlogArticle implements Serializable {
    private String content;

    private String title;

    private String likeId;

    private String dislikeId;

    private String awardGoldInfo;

    private String visibleUserid;

    private String attachments;

    private String tags;

    private static final long serialVersionUID = 1L;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLikeId() {
        return likeId;
    }

    public void setLikeId(String likeId) {
        this.likeId = likeId;
    }

    public String getDislikeId() {
        return dislikeId;
    }

    public void setDislikeId(String dislikeId) {
        this.dislikeId = dislikeId;
    }

    public String getAwardGoldInfo() {
        return awardGoldInfo;
    }

    public void setAwardGoldInfo(String awardGoldInfo) {
        this.awardGoldInfo = awardGoldInfo;
    }

    public String getVisibleUserid() {
        return visibleUserid;
    }

    public void setVisibleUserid(String visibleUserid) {
        this.visibleUserid = visibleUserid;
    }

    public String getAttachments() {
        return attachments;
    }

    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BlogArticleWithBLOBs other = (BlogArticleWithBLOBs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getAuthorId() == null ? other.getAuthorId() == null : this.getAuthorId().equals(other.getAuthorId()))
            && (this.getPrivacy() == null ? other.getPrivacy() == null : this.getPrivacy().equals(other.getPrivacy()))
            && (this.getLikeNum() == null ? other.getLikeNum() == null : this.getLikeNum().equals(other.getLikeNum()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getLikeId() == null ? other.getLikeId() == null : this.getLikeId().equals(other.getLikeId()))
            && (this.getDislikeId() == null ? other.getDislikeId() == null : this.getDislikeId().equals(other.getDislikeId()))
            && (this.getAwardGoldInfo() == null ? other.getAwardGoldInfo() == null : this.getAwardGoldInfo().equals(other.getAwardGoldInfo()))
            && (this.getVisibleUserid() == null ? other.getVisibleUserid() == null : this.getVisibleUserid().equals(other.getVisibleUserid()))
            && (this.getAttachments() == null ? other.getAttachments() == null : this.getAttachments().equals(other.getAttachments()))
            && (this.getTags() == null ? other.getTags() == null : this.getTags().equals(other.getTags()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getAuthorId() == null) ? 0 : getAuthorId().hashCode());
        result = prime * result + ((getPrivacy() == null) ? 0 : getPrivacy().hashCode());
        result = prime * result + ((getLikeNum() == null) ? 0 : getLikeNum().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getLikeId() == null) ? 0 : getLikeId().hashCode());
        result = prime * result + ((getDislikeId() == null) ? 0 : getDislikeId().hashCode());
        result = prime * result + ((getAwardGoldInfo() == null) ? 0 : getAwardGoldInfo().hashCode());
        result = prime * result + ((getVisibleUserid() == null) ? 0 : getVisibleUserid().hashCode());
        result = prime * result + ((getAttachments() == null) ? 0 : getAttachments().hashCode());
        result = prime * result + ((getTags() == null) ? 0 : getTags().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", content=").append(content);
        sb.append(", title=").append(title);
        sb.append(", likeId=").append(likeId);
        sb.append(", dislikeId=").append(dislikeId);
        sb.append(", awardGoldInfo=").append(awardGoldInfo);
        sb.append(", visibleUserid=").append(visibleUserid);
        sb.append(", attachments=").append(attachments);
        sb.append(", tags=").append(tags);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}