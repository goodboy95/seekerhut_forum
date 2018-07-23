package com.seekerhut.forum.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class ForumModel extends BaseModel implements Serializable {
    @Id //@id注意选择这个javax.persistence
    @GeneratedValue
    private  String   name;
    private  Integer   creatorID;
    private Integer viewLevel;
    private Integer postLevel;
    private String admin;
    private int status;
    //private List<Long> replyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(Integer name) {
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

/*    public List<Long> getReplyId() {
        return replyId;
    }

    public void setReplyId(List<Long> replyId) {
        this.replyId = replyId;
    }*/
}
