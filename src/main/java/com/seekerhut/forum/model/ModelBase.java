package com.seekerhut.forum.model;

import java.io.Serializable;
import java.util.Date;

public abstract class ModelBase implements Serializable {
    private int id;
    private Date createTime;
    private Boolean isDeleted;

    public ModelBase() {
        createTime = new Date();
        isDeleted = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}