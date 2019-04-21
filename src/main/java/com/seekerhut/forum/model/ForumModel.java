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

    public ForumModel setValue(JSONObject init) {
        try {
            if (init.has("id")) {
                this.id = init.getLong("id");
            }
            if (init.has("name")) {
                this.name = init.getString("name");
            }
            if (init.has("creatorId")) {
                this.creatorId = init.getLong("creatorId");
            }
            if (init.has("postLevel")) {
                this.postLevel = init.getInt("postLevel");
            }
            if (init.has("viewLevel")) {
                this.viewLevel = init.getInt("viewLevel");
            }
            if (init.has("status")) {
                this.status = init.getInt("status");
            }
            return this;
        }
        catch (Exception e) {
            return null;
        }
    }
}
