package com.seekerhut.forum.controller;

import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.seekerhut.forum.map.ForumMap;
import com.seekerhut.forum.map.PostMap;
import com.seekerhut.forum.model.ForumModel;
import com.seekerhut.forum.model.PostModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/api/forum")
public class IndexApiController extends BaseController {
    @Autowired
    private ForumMap forum;
    private PostMap post;

    @RequestMapping(value = "/forumList", method = RequestMethod.GET)
    @ApiOperation(value = "获取论坛列表", httpMethod = "GET", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "论坛名", paramType = "query", dataType = "String")
    })
    public @ResponseBody String GetForumList() {
        List<ForumModel> forumList = forum.findAll();
        return Success(forumList);
    }

    @RequestMapping(value = "/forum", method = RequestMethod.POST)
    public @ResponseBody String SaveForum(String forumJson) {
        JSONObject forumJobj = new JSONObject(forumJson);
        ForumModel entity = (forumJobj.has("id")) ? forum.getOne(forumJobj.getLong("id")) : new ForumModel();
        entity.setValue(forumJobj);
        forum.save(entity);
        return Success("save ok", entity);
    }

    @RequestMapping(value = "/postList", method = RequestMethod.GET)
    public @ResponseBody String PostList(Long forumId, int pageSize, int pageNum) {
        List<PostModel> res = post.getPosts(forumId,pageSize * pageNum, pageSize);
        return Success(res);
    }

}
