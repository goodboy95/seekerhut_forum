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
    private  Long   creatorId;
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

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return the isDeleted
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted the isDeleted to set
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the creatorId
     */
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     * @param creatorId the creatorId to set
     */
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * @return the viewLevel
     */
    public Integer getViewLevel() {
        return viewLevel;
    }

    /**
     * @param viewLevel the viewLevel to set
     */
    public void setViewLevel(Integer viewLevel) {
        this.viewLevel = viewLevel;
    }

    /**
     * @return the postLevel
     */
    public Integer getPostLevel() {
        return postLevel;
    }

    /**
     * @param postLevel the postLevel to set
     */
    public void setPostLevel(Integer postLevel) {
        this.postLevel = postLevel;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return the adminId
     */
    public LinkedList<Long> getAdminId() {
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(LinkedList<Long> adminId) {
        this.adminId = adminId;
    }

    /**
     * @return the adminName
     */
    public LinkedList<String> getAdminName() {
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(LinkedList<String> adminName) {
        this.adminName = adminName;
    }
}
