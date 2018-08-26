package com.seekerhut.forum.model;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "forum", indexes = {
        @Index(name = "idx_name", columnList = "name", unique = true)
})
//@TypeDef(name = "json", typeClass = )
public class ForumModel implements Serializable {
    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Boolean isDeleted;
    @Column(nullable = false)
    private  String   name;
    private  Long   creatorID;
    private Integer viewLevel;
    private Integer postLevel;
    private Integer status;
    @Column(name = "admin_id", columnDefinition = "json")
    private LinkedList<Long> adminId;
    @Column(name = "admin_name", columnDefinition = "json")
    private LinkedList<String> adminName;

    public ForumModel() {
        createTime = new Date();
        isDeleted = false;
    }

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

    public Long getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
    }

    public Integer getViewLevel() {
        return viewLevel;
    }

    public void setViewLevel(int viewLevel) {
        this.viewLevel = viewLevel;
    }

    public Integer getPostLevel() {
        return postLevel;
    }

    public void setPostLevel(int postLevel) {
        this.postLevel = postLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LinkedList<Long> getAdminId() {
        return adminId;
    }

    public void setAdminId(LinkedList<Long> adminId) {
        this.adminId = adminId;
    }

    public LinkedList<String> getAdminName() {
        return adminName;
    }

    public void setAdminName(LinkedList<String> adminName) {
        this.adminName = adminName;
    }
}
