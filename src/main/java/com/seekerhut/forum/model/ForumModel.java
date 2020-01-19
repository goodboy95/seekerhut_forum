package com.seekerhut.forum.model;

import java.io.Serializable;

public class ForumModel extends ModelBase implements Serializable {
    private String name;
    private Long creatorId;
    private int viewLevel;
    private int postLevel;
    private int status;
    private String adminId;
    private String adminName;

    public ForumModel() {
        super();
        viewLevel = 0;
        postLevel = 0;
        status = 0;

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
    @SuppressWarnings("unchecked")
    public String getAdminId() {
        //return JSONObject.parseObject(adminId, LinkedList.class);
        return adminId;
    }

    /**
     * @param adminId the adminId to set
     */
    public void setAdminId(String adminId) {
        //this.adminId = JSONObject.toJSONString(adminId);
        this.adminId = adminId;
    }

    /**
     * @return the adminName
     */
    @SuppressWarnings("unchecked")
    public String getAdminName() {
        //return JSONObject.parseObject(adminName, LinkedList.class);
        return adminName;
    }

    /**
     * @param adminName the adminName to set
     */
    public void setAdminName(String adminName) {
        //this.adminName = JSONObject.toJSONString(adminName);
        this.adminName = adminName;
    }
}
