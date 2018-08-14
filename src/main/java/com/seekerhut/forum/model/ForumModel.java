package com.seekerhut.forum.model;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "forum")
//@TypeDef(name = "json", typeClass = )
public class ForumModel implements Serializable {
    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private Long id;
    private Date createTime;
    private Boolean isDeleted;
    private  String   name;
    private  Integer   creatorID;
    private Integer viewLevel;
    private Integer postLevel;
    private String adminName;
    private int status;
    @Type(type = "json")
    @Column(columnDefinition = "json")
    private LinkedList<Long> replyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Integer creatorID) {
        this.creatorID = creatorID;
    }

    public Integer getViewLevel() {
        return viewLevel;
    }

    public void setViewLevel(Integer viewLevel) {
        this.viewLevel = viewLevel;
    }

    public Integer getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(Integer postLevel) {
        this.postLevel = postLevel;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LinkedList<Long> getReplyId() {
        return replyId;
    }

    public void setReplyId(LinkedList<Long> replyId) {
        this.replyId = replyId;
    }
}
