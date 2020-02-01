package com.seekerhut.model;

import java.io.Serializable;
import java.util.Date;

/**
 * forum_section
 * @author 
 */
public class ForumSection extends ModelBase implements Serializable {
    private String name;

    private Long creatorId;

    private Byte viewLevel;

    private Byte postLevel;

    private Byte status;

    private static final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public Byte getViewLevel() {
        return viewLevel;
    }

    public void setViewLevel(Byte viewLevel) {
        this.viewLevel = viewLevel;
    }

    public Byte getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(Byte postLevel) {
        this.postLevel = postLevel;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public ForumSection() {
        super();
        viewLevel = 0;
        postLevel = 0;
        status = 0;
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
        ForumSection other = (ForumSection) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getIsDeleted() == null ? other.getIsDeleted() == null : this.getIsDeleted().equals(other.getIsDeleted()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getViewLevel() == null ? other.getViewLevel() == null : this.getViewLevel().equals(other.getViewLevel()))
            && (this.getPostLevel() == null ? other.getPostLevel() == null : this.getPostLevel().equals(other.getPostLevel()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getIsDeleted() == null) ? 0 : getIsDeleted().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getViewLevel() == null) ? 0 : getViewLevel().hashCode());
        result = prime * result + ((getPostLevel() == null) ? 0 : getPostLevel().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", createTime=").append(createTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", name=").append(name);
        sb.append(", creatorId=").append(creatorId);
        sb.append(", viewLevel=").append(viewLevel);
        sb.append(", postLevel=").append(postLevel);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}