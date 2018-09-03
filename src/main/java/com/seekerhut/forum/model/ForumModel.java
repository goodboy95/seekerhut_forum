package com.seekerhut.forum.model;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.json.JSONObject;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "forum", indexes = {
        @Index(name = "idx_name", columnList = "name", unique = true)
})
public class ForumModel implements Serializable {
    @Id //@id注意选择这个javax.persistence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Date createTime;
    @Column(nullable = false)
    private Boolean isDeleted;
    @Column(nullable = false)
    private  String   name;
    @Column(nullable = false)
    private  Long   creatorID;
    @Column(nullable = false)
    private Integer viewLevel;
    @Column(nullable = false)
    private Integer postLevel;
    @Column(nullable = false)
    private Integer status;
    @Column(name = "admin_id", columnDefinition = "json")
    private LinkedList<Long> adminId;
    @Column(name = "admin_name", columnDefinition = "json")
    private LinkedList<String> adminName;

    public ForumModel() {
        createTime = new Date();
        isDeleted = false;
        viewLevel = 0;
        postLevel = 0;
        status = 0;
    }

    public ForumModel setValue(JSONObject init) {
        if (init.has("id")) { this.id = init.getLong("id"); }
        if (init.has("name")) { this.name = init.getString("name"); }
        if (init.has("creatorID")) { this.creatorID = init.getLong("creatorID"); }
        if (init.has("postLevel")) { this.postLevel = init.getInt("postLevel"); }
        if (init.has("viewLevel")) { this.viewLevel = init.getInt("viewLevel"); }
        if (init.has("status")) { this.status = init.getInt("status"); }
        return this;
    }

    public Long getId() {
        return id;
    }

    public ForumModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public ForumModel setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public ForumModel setDeleted(Boolean deleted) {
        isDeleted = deleted;
        return this;
    }

    public String getName() {
        return name;
    }

    public ForumModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getCreatorID() {
        return creatorID;
    }

    public ForumModel setCreatorID(Long creatorID) {
        this.creatorID = creatorID;
        return this;
    }

    public Integer getViewLevel() {
        return viewLevel;
    }

    public ForumModel setViewLevel(Integer viewLevel) {
        this.viewLevel = viewLevel;
        return this;
    }

    public Integer getPostLevel() {
        return postLevel;
    }

    public ForumModel setPostLevel(Integer postLevel) {
        this.postLevel = postLevel;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public ForumModel setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public LinkedList<Long> getAdminId() {
        return adminId;
    }

    public ForumModel setAdminId(LinkedList<Long> adminId) {
        this.adminId = adminId;
        return this;
    }

    public LinkedList<String> getAdminName() {
        return adminName;
    }

    public ForumModel setAdminName(LinkedList<String> adminName) {
        this.adminName = adminName;
        return this;
    }
}
